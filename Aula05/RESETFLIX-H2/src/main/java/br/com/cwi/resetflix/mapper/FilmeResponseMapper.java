package br.com.cwi.resetflix.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.cwi.resetflix.entity.FilmeEntity;
import br.com.cwi.resetflix.response.FilmeResponse;


@Component
public class FilmeResponseMapper {

    public List<FilmeResponse> mapear(final List<FilmeEntity> filmesAtor) {
        final List<FilmeResponse> responses = new ArrayList<>();

        for (final FilmeEntity filmeEntity : filmesAtor) {
            responses.add(new FilmeResponse(filmeEntity.getId(),
                filmeEntity.getNome(), filmeEntity.getGenero()));
        }

        return responses;
    }
}
