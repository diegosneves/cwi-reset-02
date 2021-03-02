package br.com.cwi.resetflix.mapper;

import java.util.List;

import br.com.cwi.resetflix.entity.AtorEntity;
import br.com.cwi.resetflix.entity.FilmeEntity;
import br.com.cwi.resetflix.response.ConsultarDetalhesAtorResponse;
import br.com.cwi.resetflix.response.FilmeResponse;

public class ConsultarDetalhesAtorResponseMapper {

    public ConsultarDetalhesAtorResponse mapear(final AtorEntity atorSalvo, final List<FilmeEntity> filmesAtor) {

        List<FilmeResponse> filmesResponse = new FilmeResponseMapper().mapear(filmesAtor);

        return new ConsultarDetalhesAtorResponse(atorSalvo.getId(),
            atorSalvo.getNome(), filmesResponse);

    }
}
