package api.pessoa.endereco.service;

import api.pessoa.endereco.dto.PessoaDto;
import api.pessoa.endereco.entity.Pessoa;
import api.pessoa.endereco.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PessoaService {

    private final PessoaRepository pessoaRepository;

    private final ModelMapper mapper;

    public List<PessoaDto> findAll() {

        var listaPessoas = pessoaRepository.findAll();

        return listaPessoas.stream()
                .map(pessoa -> mapper.map(pessoa, PessoaDto.class))
                .collect(Collectors.toList());
    }

    public PessoaDto findById(Long id) {

        var pessoa = pessoaRepository.findById(id);

        return mapper.map(pessoa,PessoaDto.class);
    }

    public PessoaDto insert(PessoaDto pessoaDto){

        var request = mapper.map(pessoaDto, Pessoa.class);

        var response = pessoaRepository.save(request);

        return mapper.map(response, PessoaDto.class);
    }

    public  PessoaDto update(PessoaDto pessoaDto, Long id){

        var pessoaPersistida = this.findById(id);

        mapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());

        mapper.map(pessoaDto, pessoaPersistida);

        this.insert(pessoaPersistida);

        return pessoaPersistida;
    }

    public void delete(Long id){

        pessoaRepository.deleteById(id);
    }
}
