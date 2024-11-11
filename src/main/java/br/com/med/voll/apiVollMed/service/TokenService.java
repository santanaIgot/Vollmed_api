package br.com.med.voll.apiVollMed.service;

import br.com.med.voll.apiVollMed.model.usuario.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

@Service
public class TokenService {
    public String getToken(Usuario usuario) {
        try {
            var algoritmo = Algorithm.HMAC256("12345678");
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
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
