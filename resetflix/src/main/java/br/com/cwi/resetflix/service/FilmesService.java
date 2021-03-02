package br.com.cwi.resetflix.service;

import br.com.cwi.resetflix.entity.AtorEntity;
import br.com.cwi.resetflix.entity.FilmeEntity;
import br.com.cwi.resetflix.mapper.ConsultarDetalhesFilmeResponseMapper;
import br.com.cwi.resetflix.mapper.FilmeEntityMapper;
import br.com.cwi.resetflix.mapper.FilmeResponseMapper;
import br.com.cwi.resetflix.repository.AtoresRepository;
import br.com.cwi.resetflix.repository.FilmeRepository;
import br.com.cwi.resetflix.request.CriarFilmeRequest;
import br.com.cwi.resetflix.response.ConsultarDetalhesFilmeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmesService {

    @Autowired
    private FilmeRepository filmeRepository;

    @Autowired
    private AtoresRepository atoresRepository;

    static ConsultarDetalhesFilmeResponseMapper MAPPER_DETALHES_FILME = new ConsultarDetalhesFilmeResponseMapper();
    static FilmeEntityMapper MAPPER_ENTITY = new FilmeEntityMapper();
    static FilmeResponseMapper MAPPER_RESPONSE = new FilmeResponseMapper();

    public ConsultarDetalhesFilmeResponse consultarDetalhesFilmePorID(Long id) {
        //FIXME Verificar o retorno da linha 34
        FilmeEntity filmeSalvo = filmeRepository.acharFilmePorID(id);

        List<AtorEntity> atoresFilme = (List<AtorEntity>) atoresRepository.acharAtorPorId(id);

        return MAPPER_DETALHES_FILME.mapear(filmeSalvo, atoresFilme);
    }

    public Long criarFilme(CriarFilmeRequest request) {

        FilmeEntity filmeSalvar = MAPPER_ENTITY.mapear(request);

        return filmeRepository.criarFilme(filmeSalvar);
    }
}
