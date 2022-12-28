package jp.co.itfllc.employeesofitf.controllers;

import org.bouncycastle.util.encoders.Hex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * A controller for the token resource.
 *
 * @author Josh Cummings
 */
@RestController
public class TokenController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/token")
    public String token(@RequestBody PostLoginBody body, Authentication authentication) throws Exception {
        Authentication authObject = null;

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(body.account, body.password));
            var context = SecurityContextHolder.getContext();
            var principal = context.getAuthentication().getPrincipal();
            var enc = new String(Hex.encode((byte[])principal));
            var dec = Hex.decode(enc);
            SecurityContextHolder.getContext().setAuthentication(authObject);
        } catch (BadCredentialsException e) {
            throw new Exception("Invalid credentials");
        }

        // TODO: JWTを生成して返す
        return "";

        // Instant now = Instant.now();
        // long expiry = 36000L;
        // // @formatter:off
		// String scope = authentication.getAuthorities().stream()
		// 		.map(GrantedAuthority::getAuthority)
		// 		.collect(Collectors.joining(" "));
        
        // // var cre = (UsersEntity)authentication.getPrincipal();
        // // Hex.decode(cre.getId());

		// JwtClaimsSet claims = JwtClaimsSet.builder()
		// 		.issuer("self")
		// 		.issuedAt(now)
		// 		.expiresAt(now.plusSeconds(expiry))
		// 		.subject(authentication.getName())
		// 		.claim("scope", scope)
		// 		.build();
		// // @formatter:on
        // return
        // this.encoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
    }

    record PostLoginBody(String account, String password) {
    }
}