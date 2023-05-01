package api.pessoa.endereco.dto;

import api.pessoa.endereco.entity.Pessoa;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class PessoaDto {

    private Long id;
    private String name;
    private Integer idade;
    private Long celular;
    private String email;
    private List<EnderecoDto> enderecos;

    public PessoaDto(Pessoa pessoa) {

        this.id = pessoa.getId();
        this.name = pessoa.getName();
        this.idade = pessoa.getIdade();
        this.celular = pessoa.getCelular();
        this.email = pessoa.getEmail();

        List<EnderecoDto> enderecoDtosList = new ArrayList<>();
        pessoa.getEnderecos().forEach(endereco -> enderecoDtosList.add(new EnderecoDto(endereco)));
        this.enderecos = enderecoDtosList;

    }
}
