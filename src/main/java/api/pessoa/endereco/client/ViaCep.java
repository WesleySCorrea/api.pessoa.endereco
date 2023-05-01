package api.pessoa.endereco.client;

import api.pessoa.endereco.dto.EnderecoDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ViaCep {


    public EnderecoDto enderecoViaCep(String cep) {

        Unirest.setTimeouts(0, 0);
        HttpResponse<String> response ;
        ObjectMapper mapper = new ObjectMapper();
        try {
            response = Unirest.get("https://viacep.com.br/ws/" + cep + "/json/")
                    .asString();
        } catch (UnirestException e) {
            throw new RuntimeException(e);
        }

        try {
            return mapper.readValue(response.getBody(), EnderecoDto.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
