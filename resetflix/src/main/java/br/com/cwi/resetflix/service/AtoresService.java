package br.com.cwi.resetflix.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.resetflix.entity.AtorEntity;
import br.com.cwi.resetflix.entity.FilmeEntity;
import br.com.cwi.resetflix.mapper.AtorEntityMapper;
import br.com.cwi.resetflix.mapper.AtoresResponseMapper;
import br.com.cwi.resetflix.mapper.ConsultarDetalhesAtorResponseMapper;
import br.com.cwi.resetflix.repository.AtoresRepository;
import br.com.cwi.resetflix.repository.FilmeRepository;
import br.com.cwi.resetflix.request.CriarAtorRequest;
import br.com.cwi.resetflix.response.AtoresResponse;
import br.com.cwi.resetflix.response.ConsultarDetalhesAtorResponse;

@Service
public class AtoresService {

    @Autowired
    private AtoresRepository atoresRepository;

    @Autowired
    private FilmeRepository filmeRepository;

    static AtoresResponseMapper MAPPER_RESPONSE = new AtoresResponseMapper();
    static AtorEntityMapper MAPPER_ENTITY = new AtorEntityMapper();
    static ConsultarDetalhesAtorResponseMapper MAPPER_DETALHES_ATOR = new ConsultarDetalhesAtorResponseMapper();

    public List<AtoresResponse> getAtores() {
        final List<AtorEntity> atores = atoresRepository.getAtores();
        return MAPPER_RESPONSE.mapear(atores);
    }

    public Long criarAtor(final CriarAtorRequest request) {
        AtorEntity atorSalvar = MAPPER_ENTITY.mapear(request);
        return atoresRepository.criarAtor(atorSalvar);
    }

    public ConsultarDetalhesAtorResponse consultarDetalhesAtor(final Long id) {
        AtorEntity atorSalvo = atoresRepository.acharAtorPorId(id);
        List<FilmeEntity> filmesAtor = filmeRepository.acharFilmesAtor(id);
        return MAPPER_DETALHES_ATOR.mapear(atorSalvo, filmesAtor);
    }
}
