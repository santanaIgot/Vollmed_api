package br.com.med.voll.apiVollMed.model.paciente;

import br.com.med.voll.apiVollMed.dto.paciente.CadastroPacienteDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter@Setter
@NoArgsConstructor
@Entity

public class Pacientes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private String sexo;
    private String email;

    @Embedded
    private EnderecoPaciente enderecoPaciente;

    public Pacientes(CadastroPacienteDto dto) {
        nome = dto.nome();
        cpf = dto.cpf();
        dataNascimento = dto.dataNascimento();
        sexo = dto.sexo();
        email = dto.email();
        enderecoPaciente = new EnderecoPaciente(dto.enderecoPaciente());
    }
}
