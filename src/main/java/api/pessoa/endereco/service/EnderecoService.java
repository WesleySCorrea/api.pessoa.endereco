package api.pessoa.endereco.service;

import api.pessoa.endereco.client.ViaCep;
import api.pessoa.endereco.dto.EnderecoDto;
import api.pessoa.endereco.entity.Endereco;
import api.pessoa.endereco.repository.EnderecoRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;

    private final ViaCep viaCep;

    private final ModelMapper mapper;

    public List<EnderecoDto> findAll() {

        var listaEndereco = enderecoRepository.findAll();

        return listaEndereco.stream()
                .map(endereco -> mapper.map(endereco, EnderecoDto.class))
                .collect(Collectors.toList());
    }

    public EnderecoDto findById(Long id) {

        var endereco = enderecoRepository.findById(id);

        return mapper.map(endereco,EnderecoDto.class);
    }

    public EnderecoDto insert(EnderecoDto enderecoDto){

        var enderecoViaCep = viaCep.enderecoViaCep(enderecoDto.getCep());

        mapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());

        mapper.map(enderecoViaCep, enderecoDto);

        var request = mapper.map(enderecoDto, Endereco.class);

        var response = enderecoRepository.save(request);

        return mapper.map(response, EnderecoDto.class);
    }

    public  EnderecoDto update(EnderecoDto enderecoDto, Long id){

        var enderecoPersistido = this.findById(id);

        mapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());

        mapper.map(enderecoDto, enderecoPersistido);

        this.insert(enderecoPersistido);

        return enderecoPersistido;
    }

    public void delete(Long id){

        enderecoRepository.deleteById(id);
    }
}
