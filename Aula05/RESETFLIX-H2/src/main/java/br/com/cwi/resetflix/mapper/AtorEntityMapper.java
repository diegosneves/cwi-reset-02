package br.com.cwi.resetflix.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.cwi.resetflix.entity.AtorEntity;
import br.com.cwi.resetflix.entity.FilmeEntity;
import br.com.cwi.resetflix.request.CriarAtorRequest;

@Component
public class AtorEntityMapper {

    public AtorEntity mapear(final CriarAtorRequest request, final List<FilmeEntity> filmes) {
        return new AtorEntity(request.getNome(), filmes);
    }
}
