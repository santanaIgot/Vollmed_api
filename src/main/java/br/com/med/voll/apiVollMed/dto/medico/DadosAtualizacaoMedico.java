package br.com.med.voll.apiVollMed.dto.medico;

import br.com.med.voll.apiVollMed.dto.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoMedico(@NotNull Long id, String nome, String telefone, DadosEndereco endereco) {


}
