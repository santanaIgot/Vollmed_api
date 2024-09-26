package br.com.med.voll.apiVollMed.model.medico;

import br.com.med.voll.apiVollMed.dto.endereco.DadosEndereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Embeddable
@Getter@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "MEDICOS")
public class Endereco {

    private String logradouro;
    private String bairro;
    private String cep;
    private String numero;
    private String complemento;
    private String cidade;
    private String uf;

    public void atualizarDados(DadosEndereco dadosEndereco ){
        if(dadosEndereco.logradouro() != null){
            this.logradouro = dadosEndereco.logradouro();
        }
        if(dadosEndereco.bairro() != null){
            this.bairro = dadosEndereco.bairro();
        }
        if(dadosEndereco.cep() != null){
            this.cep = dadosEndereco.cep();
        }

        if(dadosEndereco.cidade() != null){
            this.cidade = dadosEndereco.cidade();
        }

        if (dadosEndereco.numero() != null){
            this.numero = dadosEndereco.numero();
        }

        if(dadosEndereco.uf() != null){
            this.uf = dadosEndereco.uf();
        }



    }


    public Endereco(DadosEndereco dados) {
        this.logradouro = dados.logradouro();
        this.bairro = dados.bairro();
        this.cep = dados.cep();
        this.uf = dados.uf();
        this.cidade = dados.cidade();
        this.numero = dados.numero();

    }
}
