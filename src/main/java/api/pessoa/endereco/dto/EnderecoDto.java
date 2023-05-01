package api.pessoa.endereco.dto;

import api.pessoa.endereco.entity.Endereco;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class EnderecoDto {

    private Long id;
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private String ibge;
    private String gia;
    private String ddd;
    private String siafi;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private PessoaDto pessoa;

    public EnderecoDto(Endereco endereco){

        this.id = endereco.getId();
        this.cep = endereco.getCep();
        this.logradouro = endereco.getLogradouro();
        this.complemento = endereco.getComplemento();
        this.bairro = endereco.getBairro();
        this.localidade = endereco.getLocalidade();
        this.uf = endereco.getUf();
        this.ibge = endereco.getIbge();
        this.gia = endereco.getGia();
        this.ddd = endereco.getDdd();
        this.siafi = endereco.getSiafi();

        var pessoaDto = new PessoaDto();
        pessoaDto.setId(endereco.getPessoa().getId());
        this.pessoa = pessoaDto;
    }
}
