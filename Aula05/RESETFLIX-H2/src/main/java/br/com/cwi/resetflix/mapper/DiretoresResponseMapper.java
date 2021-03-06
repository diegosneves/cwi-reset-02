package br.com.cwi.resetflix.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.cwi.resetflix.entity.DiretorEntity;
import br.com.cwi.resetflix.response.AtoresResponse;
import br.com.cwi.resetflix.response.DiretoresResponse;


@Component
public class DiretoresResponseMapper {

    public List<DiretoresResponse> mapear(final List<DiretorEntity> diretores) {
        final List<DiretoresResponse> diretoresResponses = new ArrayList<>();

        for (final DiretorEntity diretor : diretores) {

            final DiretoresResponse novoDiretor = new DiretoresResponse(diretor.getId(),
                diretor.getNome());

            diretoresResponses.add(novoDiretor);
        }

        return diretoresResponses;
    }
}
