package br.com.med.voll.apiVollMed.controller;

import br.com.med.voll.apiVollMed.medico.DadosCadastroMedico;
import br.com.med.voll.apiVollMed.medico.DadosListagemMedico;
import br.com.med.voll.apiVollMed.medico.Medico;
import br.com.med.voll.apiVollMed.medico.MedicoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {
    @Autowired
    private MedicoRepository medicoRepository;
    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados){
        medicoRepository.save(new Medico(dados));
    }

    @GetMapping
    public Page<DadosListagemMedico> listar(Pageable paginacao){
        return medicoRepository.findAll(paginacao).map(DadosListagemMedico::new);
    }
}
