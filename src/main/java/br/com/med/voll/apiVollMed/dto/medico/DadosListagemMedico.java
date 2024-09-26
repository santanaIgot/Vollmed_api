package br.com.med.voll.apiVollMed.dto.medico;

import br.com.med.voll.apiVollMed.model.medico.Especialidade;
import br.com.med.voll.apiVollMed.model.medico.Medico;

public record DadosListagemMedico(Long id, String nome, String email, String crm, Especialidade especialidade) {

        public DadosListagemMedico(Medico medico){
            this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
        }

}
