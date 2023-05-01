package api.pessoa.endereco.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "endereços")
@JsonInclude(JsonInclude.Include.NON_EMPTY)

public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cep" )
    private String cep;

    @Column(name = "logradouro" )
    private String logradouro;

    @Column(name = "complemento" )
    private String complemento;

    @Column(name = "bairro" )
    private String bairro;

    @Column(name = "localidade" )
    private String localidade;

    @Column(name = "uf" )
    private String uf;

    @Column(name = "ibge" )
    private String ibge;

    @Column(name = "gia" )
    private String gia;

    @Column(name = "ddd" )
    private String ddd;

    @Column(name = "siafi" )
    private String siafi;

    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;
}
