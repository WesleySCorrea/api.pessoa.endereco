package api.pessoa.endereco.controller;

import api.pessoa.endereco.dto.PessoaDto;
import api.pessoa.endereco.service.PessoaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/v1/pessoas")
public class PessoaController {

    private final PessoaService pessoaService;

    @GetMapping
    public ResponseEntity<List<PessoaDto>> findAll(){

        var listaPessoas = pessoaService.findAll();

        return ResponseEntity.ok().body(listaPessoas);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PessoaDto> findById(@PathVariable Long id) {

        var pessoa = pessoaService.findById(id);

        return ResponseEntity.ok().body(pessoa);
    }

    @PostMapping
    public ResponseEntity<PessoaDto> insert(@RequestBody PessoaDto pessoaDto){

        var pessoa = pessoaService.insert(pessoaDto);

        return ResponseEntity.ok().body(pessoa);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<PessoaDto> update(@RequestBody PessoaDto pessoaDto, @PathVariable Long id){

        var pessoa = pessoaService.update(pessoaDto, id);

        return ResponseEntity.ok().body(pessoa);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){

        pessoaService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
