package br.com.med.voll.apiVollMed.service;

import br.com.med.voll.apiVollMed.model.usuario.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

@Service
public class TokenService {
    @Value("${api.security.token.secret}")
    private String secret;
    public String getToken(Usuario usuario) {
        System.out.println(secret);
        try {
            var algoritmo = Algorithm.HMAC256(secret);
             return JWT.create()
                    .withIssuer("API voll med")
                     .withSubject(usuario.getLogin())
                     .withClaim("id", usuario.getId())
                     .withExpiresAt(dataExpiracao())
                    .sign(algoritmo);
        } catch (JWTCreationException exception){
           throw new RuntimeException("JWT generation failed", exception);
        }
    }

    private Instant dataExpiracao() {
        return LocalDateTime.now().plusHours(5).toInstant(ZoneOffset.of("-03:00"));
    }


    public String getSubject(String tokenJWT) {
        try {
            var algoritmo = Algorithm.HMAC256(secret);
            return JWT.require(algoritmo)
                    .withIssuer("API voll med")
                    .build()
                    .verify(tokenJWT.trim())
                    .getSubject();
        } catch (JWTVerificationException exception){
           throw new RuntimeException("JWT generation failed", exception);
        }
    }
}
