package com.heavymaverick.sprsecdemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.*;

import java.util.Date;

@Component
public class JwtCore {
    @Value("${testing.app.secret}")
    private String secret;
    @Value("${testing.app.expirationMs}")
    private int lifetime;
    // Зашиваем по желанию в ключ данные + секрет
    public String generateToken(Authentication authentication) {
        UserDetailsImpl user = (UserDetailsImpl) authentication.getPrincipal();
        return Jwts.builder().subject((user.getUsername())).issuedAt(new Date())
                .expiration(new Date((new Date()).getTime() + lifetime))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    public String getNameFromJwt(String jwt) {
        return Jwts.parser().setSigningKey(secret).build().parseClaimsJws(jwt).getBody().getSubject();
    } // вроде правильно работает хоть и устаревший
}
