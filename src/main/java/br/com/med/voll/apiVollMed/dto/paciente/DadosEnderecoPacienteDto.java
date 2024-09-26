package br.com.med.voll.apiVollMed.dto.paciente;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosEnderecoPacienteDto(
        @NotBlank
        String rua,
        @NotBlank
        String numero,
        String complemento,
        @NotBlank
        String bairro,
        @NotBlank
        String cidade,
        @NotBlank
        String estado,
        @NotBlank
        @Pattern(regexp = "\\d{8}")
        String cep
        ) {
}
