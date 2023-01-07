package jp.co.itfllc.employeesofitf.controllers;

import java.time.Instant;
import java.util.stream.Collectors;

import org.bouncycastle.util.encoders.Hex;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.co.itfllc.employeesofitf.security.AppUserDetails;
import jp.co.itfllc.employeesofitf.services.AuthorizationService;

/**
 * 認証Controller
 */
@RestController()
@RequestMapping("/authentication")
public class AuthenticationController {
    /**
     * JWTの有効期限(秒)
     */
    @Value("${security.jwt.expiration-time}")
    private Integer jwtExpirationTime;

    /**
     * AuthenticationManager
     */
    private final AuthenticationManager authenticationManager;

    /**
     * JwtEncoder
     */
    private final JwtEncoder encoder;

    /**
     * AuthorizationService
     */
    private final AuthorizationService authorizationService;

    /**
     * コンストラクター
     *
     * @param authenticationManager AuthenticationManager
     * @param encoder               JwtEncoder
     * @param authorizationService  AuthorizationService
     */
    public AuthenticationController(AuthenticationManager authenticationManager, JwtEncoder encoder,
            AuthorizationService authorizationService) {
        this.authenticationManager = authenticationManager;
        this.encoder = encoder;
        this.authorizationService = authorizationService;
    }

    /**
     * 認証
     *
     * @param body 認証情報
     * @return JWT
     */
    @PostMapping("/login")
    public LoginReponse login(@RequestBody PostLoginBody body) {
        // Spring Securityに認証処理を依頼する
        var authenticationToken = new UsernamePasswordAuthenticationToken(body.account, body.password);
        Authentication authentication = authenticationManager.authenticate(authenticationToken);

        // レスポンス(JWT)の生成
        String jwt = this.generateJwt(authentication);

        // リフレッシュトークンの更新
        AppUserDetails user = (AppUserDetails) authentication.getPrincipal();
        String refreshToken = this.authorizationService.updateRefreshToken(user.getId());

        return new LoginReponse(jwt, refreshToken);
    }

    /**
     * ログアウト
     *
     * @param authentication 認証情報
     */
    @PostMapping("/logout")
    public void logout(Authentication authentication) {
        byte[] userId = Hex.decode(authentication.getName());
        this.authorizationService.logout(userId);
    }

    /**
     * JWTを生成する
     *
     * @param authentication 認証情報
     * @return JWT
     */
    private String generateJwt(Authentication authentication) {
        AppUserDetails user = (AppUserDetails) authentication.getPrincipal();
        String userId = new String(Hex.encode(user.getId()));
        Instant now = Instant.now();
        String scope = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(" "));
        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer("itfllc.co.jp")
                .issuedAt(now)
                .expiresAt(now.plusSeconds(this.jwtExpirationTime))
                .subject(userId)
                .claim("scope", scope)
                .build();
        String jwt = this.encoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();

        return jwt;
    }

    /**
     * loginメソッドのリクエストボディー
     */
    public record PostLoginBody(String account, String password) {
    }

    /**
     * loginメソッドのレスポンス
     */
    public record LoginReponse(String jwt, String refreshToken) {
    }
}