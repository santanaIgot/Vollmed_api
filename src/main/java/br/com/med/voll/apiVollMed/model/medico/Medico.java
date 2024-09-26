package br.com.med.voll.apiVollMed.model.medico;

import br.com.med.voll.apiVollMed.dto.medico.DadosAtualizacaoMedico;
import br.com.med.voll.apiVollMed.dto.medico.DadosCadastroMedico;
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
        nome = dados.nome();
        email = dados.email();
        crm = dados.crm();
        telefone = dados.telefone();
        especialidade = dados.especialidade();
        endereco = new Endereco(dados.endereco());
    }

    public void atualizarDados(DadosAtualizacaoMedico dados) {
        if(dados.nome() != null)
            nome = dados.nome();
        if (dados.telefone() != null)
            telefone = dados.telefone();
        if(dados.endereco() != null)
            endereco = new Endereco(dados.endereco());
    }
}
