package br.com.med.voll.apiVollMed.controller;

import br.com.med.voll.apiVollMed.dto.medico.DadosAtualizacaoMedico;
import br.com.med.voll.apiVollMed.dto.medico.DadosCadastroMedico;
import br.com.med.voll.apiVollMed.dto.medico.DadosDetalhamentoMedico;
import br.com.med.voll.apiVollMed.dto.medico.DadosListagemMedico;

import br.com.med.voll.apiVollMed.model.medico.*;
import br.com.med.voll.apiVollMed.repository.MedicoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping("/medicos")
public class MedicoController {
    @Autowired
    private MedicoRepository medicoRepository;
    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroMedico dados,
                                    UriComponentsBuilder uriBuilder){
        var medico = new Medico(dados);
        medicoRepository.save(medico);
        var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoMedico(medico));
    }


    @GetMapping("{id}")
    public ResponseEntity detalhar(@PathVariable Long id){
        var medico = medicoRepository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoMedico(medico));
    }

    @GetMapping
    public  ResponseEntity<Page<DadosListagemMedico>> listar(Pageable paginacao){
        var page = medicoRepository.findAll(paginacao).map(DadosListagemMedico::new);

        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoMedico dados){
        var medico = medicoRepository.getReferenceById(dados.id());
        medico.atualizarDados(dados);

        return ResponseEntity.ok(new DadosDetalhamentoMedico(medico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
        medicoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}
