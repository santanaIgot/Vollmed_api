package br.com.med.voll.apiVollMed.dto.medico;


import br.com.med.voll.apiVollMed.dto.endereco.DadosEndereco;
import br.com.med.voll.apiVollMed.model.medico.Especialidade;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroMedico(

        @NotBlank
        String nome,
        @NotBlank
        @Email
        String email,
        @NotBlank
        @Pattern(regexp = "\\d{4,6}")
        String crm,
        @NotBlank
        String telefone,

        @NotNull
        Especialidade especialidade,
        @Valid
        @NotNull
        DadosEndereco endereco ) {
}
