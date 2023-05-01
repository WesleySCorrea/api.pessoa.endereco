package api.pessoa.endereco.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pessoas")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome" )
    private String name;

    @Column(name = "idade" )
    private Integer idade;

    @Column(name = "celular" )
    private Long celular;

    @Column(name = "email" )
    private String email;

    @Column(name = "enderecos" )
    @OneToMany(mappedBy = "pessoa",fetch = FetchType.LAZY)
    private List<Endereco> enderecos;

}
