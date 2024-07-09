package br.com.med.voll.apiVollMed.medico;

import br.com.med.voll.apiVollMed.endereco.Endereco;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "MEDICOS")
@Entity(name = "Medico")

@Getter@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
public class Medico {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String crm;
    private String telefone;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private Endereco endereco;

    public Medico(DadosCadastroMedico dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.crm = dados.crm();
        this.telefone = dados.telefone();
        this.especialidade = dados.especialidade();
        this.endereco = new Endereco(dados.endereco());
    }
}
