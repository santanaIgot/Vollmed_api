package br.com.med.voll.apiVollMed.model.usuario;

import jakarta.persistence.*;
import lombok.*;

@Entity()
@Table(name = "USUARIO")
@Getter@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String senha;
}
