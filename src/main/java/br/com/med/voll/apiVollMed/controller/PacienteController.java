package br.com.med.voll.apiVollMed.controller;

import br.com.med.voll.apiVollMed.dto.paciente.CadastroPacienteDto;
import br.com.med.voll.apiVollMed.dto.paciente.DetalhesPacienteDto;
import br.com.med.voll.apiVollMed.model.paciente.Pacientes;
import br.com.med.voll.apiVollMed.repository.PacienteRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    @Autowired
    private PacienteRepository pacienteRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid CadastroPacienteDto dto,
                                    UriComponentsBuilder uriBuilder) {
        var paciente = new Pacientes(dto);
        pacienteRepository.save(paciente);
        var uri = uriBuilder.path("/pacientes/{id}").buildAndExpand(paciente.getId()).toUri();

        return ResponseEntity.created(uri).body(new DetalhesPacienteDto(paciente));
    }
}
