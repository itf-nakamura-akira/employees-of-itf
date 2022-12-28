package jp.co.itfllc.employeesofitf.controllers;

import java.time.Instant;
import java.util.stream.Collectors;

import org.bouncycastle.util.encoders.Hex;
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

/**
 * 認証Controller
 */
@RestController()
@RequestMapping("/authentication")
public class AuthenticationController {
    /**
     * AuthenticationManager
     */
    private final AuthenticationManager authenticationManager;

    /**
     * JwtEncoder
     */
    private final JwtEncoder encoder;

    /**
     * コンストラクター
     *
     * @param authenticationManager AuthenticationManager
     * @param encoder               JwtEncoder
     */
    public AuthenticationController(AuthenticationManager authenticationManager, JwtEncoder encoder) {
        this.authenticationManager = authenticationManager;
        this.encoder = encoder;
    }

    /**
     * 認証
     *
     * @param body 認証情報
     * @return JWT
     * @throws Exception 認証失敗
     */
    @PostMapping("/login")
    public LoginReponse login(@RequestBody PostLoginBody body) throws Exception {
        // Spring Securityに認証処理を依頼する
        var authenticationToken = new UsernamePasswordAuthenticationToken(body.account, body.password);
        Authentication authentication = authenticationManager.authenticate(authenticationToken);

        // レスポンス(JWT)の生成
        String jwt = this.generateJwt(authentication);

        // TODO: リフレッシュトークンの生成

        return new LoginReponse(jwt);
    }

    /**
     * JWTを生成する
     *
     * @param authentication 認証情報
     * @return JWT
     */
    private String generateJwt(Authentication authentication) {
        // TODO: 設定とか見てない
        AppUserDetails user = (AppUserDetails) authentication.getPrincipal();
        String userId = new String(Hex.encode(user.getId()));
        Instant now = Instant.now();
        long expiry = 36000L;
        String scope = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(" "));
        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer("itfllc.co.jp")
                .issuedAt(now)
                .expiresAt(now.plusSeconds(expiry))
                .subject(userId)
                .claim("scope", scope)
                .build();
        String jwt = this.encoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();

        return jwt;
    }

    /**
     * loginメソッドのリクエストボディー
     */
    private record PostLoginBody(String account, String password) {
    }

    /**
     * loginメソッドのレスポンス
     */
    private record LoginReponse(String jwt) {
    }
}