package br.com.cwi.resetflix.mapper;

import java.util.ArrayList;
import java.util.List;

import br.com.cwi.resetflix.entity.FilmeEntity;
import br.com.cwi.resetflix.response.FilmeResponse;

public class FilmeResponseMapper {

    public List<FilmeResponse> mapear(final List<FilmeEntity> filmes) {
        List<FilmeResponse> responses = new ArrayList<>();

        for(FilmeEntity filmeEntity : filmes){
            responses.add(new FilmeResponse(filmeEntity.getId(),
                filmeEntity.getNome(), filmeEntity.getGenero()));
        }

        return responses;
    }
}
