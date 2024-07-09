package br.com.med.voll.apiVollMed.medico;


import br.com.med.voll.apiVollMed.endereco.DadosEndereco;

public record DadosCadastroMedico(String nome, String email, String crm, Especialidade especialidade,
                                  DadosEndereco endereco ) {
}
