package br.com.cwi.resetflix.service;

import static java.util.Collections.emptyList;
import static org.apache.logging.log4j.util.Strings.isEmpty;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.resetflix.entity.AtorEntity;
import br.com.cwi.resetflix.entity.FilmeEntity;
import br.com.cwi.resetflix.exception.BadRequestException;
import br.com.cwi.resetflix.exception.NotFoundException;
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

    //TODO Criar Repositories
    @Autowired
    private AtoresRepository atoresRepository;

    @Autowired
    private FilmeRepository filmeRepository;

    @Autowired
    private AtoresResponseMapper atoresResponseMapper;

    @Autowired
    private AtorEntityMapper atorEntityMapper;

    @Autowired
    private ConsultarDetalhesAtorResponseMapper consultarDetalhesAtorResponseMapper;

    public List<AtoresResponse> getAtores() {
        final List<AtorEntity> atores = atoresRepository.findAll();
        return atoresResponseMapper.mapear(atores);
    }

    @Transactional
    public Long criarAtor(final CriarAtorRequest request) {

        if (request == null || isEmpty(request.getNome())) {
            throw new BadRequestException("Dados inválidos para cadastro de ator");
        }

        final List<FilmeEntity> filmes = filmeRepository.findAllById(request.getIdFilmes());

        final AtorEntity atorSalvar = atorEntityMapper.mapear(request, filmes);

        atoresRepository.save(atorSalvar);

        for (FilmeEntity filme : filmes) {
            filme.getAtores().add(atorSalvar);
        }

        return atorSalvar.getId();
    }

    public ConsultarDetalhesAtorResponse consultarDetalhesAtor(final Long id) {

        final AtorEntity atorSalvo = atoresRepository.findById(id).orElse(null);

        if (atorSalvo == null) {
            throw new NotFoundException("Ator não encontrado");
        }

        return consultarDetalhesAtorResponseMapper.mapear(atorSalvo);
    }
}
