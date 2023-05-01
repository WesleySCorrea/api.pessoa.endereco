package api.pessoa.endereco.controller;

import api.pessoa.endereco.dto.EnderecoDto;
import api.pessoa.endereco.service.EnderecoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/v1/enderecos")
public class EnderecoController {

    private final EnderecoService enderecoService;

    @GetMapping
    public ResponseEntity<List<EnderecoDto>> findAll(){

        var listaEnderecos = enderecoService.findAll();

        return ResponseEntity.ok().body(listaEnderecos);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<EnderecoDto> findById(@PathVariable Long id) {

        var endereco = enderecoService.findById(id);

        return ResponseEntity.ok().body(endereco);
    }

    @PostMapping
    public ResponseEntity<EnderecoDto> insert(@RequestBody EnderecoDto enderecoDto){

        var endereco = enderecoService.insert(enderecoDto);

        return ResponseEntity.ok().body(endereco);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<EnderecoDto> update(@RequestBody EnderecoDto enderecoDto,@PathVariable Long id){

        var endereco = enderecoService.update(enderecoDto, id);

        return ResponseEntity.ok().body(endereco);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){

        enderecoService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
