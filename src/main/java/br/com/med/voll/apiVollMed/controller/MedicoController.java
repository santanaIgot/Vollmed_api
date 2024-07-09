package br.com.med.voll.apiVollMed.controller;

import br.com.med.voll.apiVollMed.medico.DadosCadastroMedico;
import br.com.med.voll.apiVollMed.medico.Medico;
import br.com.med.voll.apiVollMed.medico.MedicoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medicos")
public class MedicoController {
    @Autowired
    private MedicoRepository medicoRepository;
    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody DadosCadastroMedico dados){
        medicoRepository.save(new Medico(dados));
    }
}
