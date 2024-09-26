package br.com.med.voll.apiVollMed.dto.medico;

import br.com.med.voll.apiVollMed.model.medico.Endereco;
import br.com.med.voll.apiVollMed.model.medico.Especialidade;
import br.com.med.voll.apiVollMed.model.medico.Medico;

public record DadosDetalhamentoMedico(Long id, String nome, String email, String crm,
                                      String telefone, Especialidade especialidade,
                                      Endereco endereco) {

    public DadosDetalhamentoMedico(Medico medico){
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(),
                medico.getTelefone(), medico.getEspecialidade(),medico.getEndereco());
    }
}
