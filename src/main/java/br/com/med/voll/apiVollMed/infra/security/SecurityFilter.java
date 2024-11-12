package br.com.med.voll.apiVollMed.infra.security;

import br.com.med.voll.apiVollMed.repository.UsuarioRepository;
import br.com.med.voll.apiVollMed.service.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {
    @Autowired
    private TokenService tokenService;


    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        System.out.println("CHAMANDO FILTRO");
        var tokenJWT = recuperarToken(request);

        if (tokenJWT != null) {

            try {
                var subject = tokenService.getSubject(tokenJWT);
                var usuario = usuarioRepository.findByLogin(subject);

                var authentication = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authentication);
                        System.out.println("Subject (usuário autenticado): " + subject);
            } catch (RuntimeException e) {
                System.out.println("Erro na verificação do token: " + e.getMessage());
            }
        }

        System.out.println("Token: " + tokenJWT);
        filterChain.doFilter(request, response);
    }

    private String recuperarToken(HttpServletRequest request) {
        var authorizationHeader = request.getHeader("Authorization");
        System.out.println("Authorization Header: " + authorizationHeader);
        if(authorizationHeader != null){
            return authorizationHeader.replace("Bearer ", "").trim();
        }
    return  null;
    }
}
