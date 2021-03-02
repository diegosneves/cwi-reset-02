package br.com.cwi.resetflix.repository;

import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.cwi.resetflix.mapper.ConsultarDetalhesAtorResponseMapper;
import org.springframework.stereotype.Repository;

import br.com.cwi.resetflix.domain.Genero;
import br.com.cwi.resetflix.entity.FilmeEntity;

@Repository
public class FilmeRepository {

    static List<FilmeEntity> filmes = new ArrayList<>();
    static Long contadorIDs = 1l;

//    static ConsultarDetalhesAtorResponseMapper MAPPER_DETALHES_ATOR = new ConsultarDetalhesAtorResponseMapper();



    public List<FilmeEntity> getFilmes(){
        return filmes;
    }

    public List<FilmeEntity> acharFilmesAtor(final Long id) {
        //TODO Filtrar na repository por id de ator

        return filmes;
    }

    public FilmeEntity acharFilmePorID(Long id) {
        for( FilmeEntity filmeEntity : filmes) {
            if(filmeEntity.getId().equals(id)){
                return filmeEntity;
            }
        }
        return null;
    }

    public Long criarFilme(FilmeEntity filmeSalvar) {

        if(filmeSalvar.getId() == null){
            filmeSalvar.setId(contadorIDs++);
        }

        filmes.add(filmeSalvar);

        return filmeSalvar.getId();
    }
}
