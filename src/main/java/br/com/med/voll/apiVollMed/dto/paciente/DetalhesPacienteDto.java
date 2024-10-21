package br.com.med.voll.apiVollMed.dto.paciente;

import br.com.med.voll.apiVollMed.model.paciente.EnderecoPaciente;

import br.com.med.voll.apiVollMed.model.paciente.Pacientes;

import java.time.LocalDate;

public record DetalhesPacienteDto(Long id, String nome, LocalDate dataNascimento,
                                  String sexo, String email , EnderecoPaciente enderecoPaciente) {

    public DetalhesPacienteDto(Pacientes paciente) {
        this(paciente.getId(), paciente.getCpf(), paciente.getDataNascimento(),
                paciente.getSexo(), paciente.getEmail(), paciente.getEnderecoPaciente()
        );
    }
}
