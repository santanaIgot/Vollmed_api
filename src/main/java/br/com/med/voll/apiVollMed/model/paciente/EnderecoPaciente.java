package br.com.med.voll.apiVollMed.model.paciente;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoPaciente {
    private String rua;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;

    public EnderecoPaciente(EnderecoPaciente enderecoPaciente) {
        this.rua = enderecoPaciente.getRua();
        this.numero = enderecoPaciente.getNumero();
        this.complemento = enderecoPaciente.getComplemento();
        this.bairro = enderecoPaciente.getBairro();
        this.cidade = enderecoPaciente.getCidade();
        this.estado = enderecoPaciente.getEstado();
        this.cep = enderecoPaciente.getCep();
    }
}
