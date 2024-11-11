package br.com.med.voll.apiVollMed.controller;

import br.com.med.voll.apiVollMed.dto.usuario.DadosDtoAutenticacao;
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

    //
    @PostMapping
    public ResponseEntity logar(@RequestBody @Valid DadosDtoAutenticacao dto) {
        var token = new UsernamePasswordAuthenticationToken(dto.login(), dto.senha());

        var authentication = manager.authenticate(token);

        return ResponseEntity.ok().build();

    }
}
