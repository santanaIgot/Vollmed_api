package br.com.med.voll.apiVollMed.controller;

import br.com.med.voll.apiVollMed.dto.DadosDtoToken;
import br.com.med.voll.apiVollMed.dto.usuario.DadosDtoAutenticacao;
import br.com.med.voll.apiVollMed.model.usuario.Usuario;
import br.com.med.voll.apiVollMed.service.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    //
    @PostMapping
    public ResponseEntity logar(@RequestBody @Valid DadosDtoAutenticacao dto) {
        var athenticationToken = new UsernamePasswordAuthenticationToken(dto.login(), dto.senha());

        var authentication = manager.authenticate(athenticationToken);

        var tokenJWT = tokenService.getToken((Usuario) authentication.getPrincipal());

        return ResponseEntity.ok(new DadosDtoToken(tokenJWT));

    }
}
