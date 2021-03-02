package br.com.cwi.resetflix.mapper;

import br.com.cwi.resetflix.entity.AtorEntity;
import br.com.cwi.resetflix.entity.DiretorEntity;
import br.com.cwi.resetflix.entity.FilmeEntity;
import br.com.cwi.resetflix.response.AtoresResponse;
import br.com.cwi.resetflix.response.ConsultarDetalhesFilmeResponse;
import br.com.cwi.resetflix.response.DiretoresResponse;

import java.util.List;

public class ConsultarDetalhesFilmeResponseMapper {

    public ConsultarDetalhesFilmeResponse mapear(FilmeEntity filmeSalvo, DiretorEntity diretor, List<AtorEntity> atoresFilme) {
        //FIXME Verificar os erros aqui
        List<AtoresResponse> atoresResponses = new AtoresResponseMapper().mapear(atoresFilme);

        return new ConsultarDetalhesFilmeResponse(filmeSalvo.getId(), filmeSalvo.getNome(), filmeSalvo.getGenero(),
                new DiretoresResponse(diretor.getId(), diretor.getNome()), atoresResponses);
    }
}
