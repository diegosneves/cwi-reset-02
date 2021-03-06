package br.com.cwi.resetflix.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.cwi.resetflix.entity.DiretorEntity;
import br.com.cwi.resetflix.entity.FilmeEntity;
import br.com.cwi.resetflix.response.ConsultarDetalhesDiretorResponse;
import br.com.cwi.resetflix.response.FilmeResponse;


@Component
public class ConsultarDetalhesDiretorResponseMapper {

    public ConsultarDetalhesDiretorResponse mapear(final DiretorEntity diretorSalvo) {
        final List<FilmeResponse> filmesResponse = new FilmeResponseMapper().mapear(diretorSalvo.getFilmes());
        return new ConsultarDetalhesDiretorResponse(diretorSalvo.getId(),
            diretorSalvo.getNome(), filmesResponse);
    }
}
