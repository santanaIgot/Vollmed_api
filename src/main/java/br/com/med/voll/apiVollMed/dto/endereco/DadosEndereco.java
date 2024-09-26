package br.com.med.voll.apiVollMed.dto.endereco;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosEndereco(
        @NotBlank
                @NotNull
        String logradouro,
        @NotBlank
                @NotNull
        String bairro,
        @NotBlank
                @Pattern(regexp = "\\d{8}")
        String cep,
        @NotBlank
                @NotNull
        String cidade,
        @NotBlank
                @NotNull
        String uf,

        String numero
) {

}
