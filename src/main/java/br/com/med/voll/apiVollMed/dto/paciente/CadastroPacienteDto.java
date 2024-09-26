package br.com.med.voll.apiVollMed.dto.paciente;

import br.com.med.voll.apiVollMed.model.paciente.EnderecoPaciente;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

public record CadastroPacienteDto(@NotBlank
                                  String nome,

                                  @NotBlank
                                  @Pattern(regexp = "\\d{11}")
                                  String cpf,

                                  @NotNull
                                  LocalDate dataNascimento,

                                  String sexo,

                                  @Email
                                  String email,

                                  @NotNull
                                          @Valid
                                  EnderecoPaciente enderecoPaciente
                ) {
}
