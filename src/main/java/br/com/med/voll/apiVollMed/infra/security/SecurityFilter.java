package br.com.med.voll.apiVollMed.infra.security;

import br.com.med.voll.apiVollMed.service.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {
    @Autowired
    private TokenService tokenService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if (request.getRequestURI().equals("/login")) {
            filterChain.doFilter(request, response);  // Passa a requisição adiante sem fazer verificação de token
            return;
        }



        var tokenJWT = recuperarToken(request);

        if (tokenJWT != null) {
            try {
                var subject = tokenService.getSubject(tokenJWT);
                System.out.println("Subject (usuário autenticado): " + subject);
            } catch (RuntimeException e) {
                System.out.println("Erro na verificação do token: " + e.getMessage());
                // Opcional: Você pode adicionar lógica para enviar uma resposta de erro se o token for inválido
                // response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Token inválido");
                // return;
            }
        }

        System.out.println("Token: " + tokenJWT);
        filterChain.doFilter(request, response);
    }

    private String recuperarToken(HttpServletRequest request) {
        var authorizationHeader = request.getHeader("Authorization");
        System.out.println("Authorization Header: " + authorizationHeader);
        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            throw new RuntimeException("Token JWT não enviado no cabeçalho Authorization!");
        }
        return authorizationHeader.replace("Bearer ", "").trim();
    }
}
