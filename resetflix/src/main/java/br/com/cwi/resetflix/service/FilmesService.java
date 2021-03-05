package br.com.cwi.resetflix.service;

import br.com.cwi.resetflix.domain.Genero;
import br.com.cwi.resetflix.entity.AtorEntity;
import br.com.cwi.resetflix.entity.DiretorEntity;
import br.com.cwi.resetflix.entity.FilmeEntity;
import br.com.cwi.resetflix.exception.NotFoundException;
import br.com.cwi.resetflix.mapper.ConsultarDetalhesFilmeResponseMapper;
import br.com.cwi.resetflix.mapper.FilmeEntityMapper;
import br.com.cwi.resetflix.mapper.FilmeResponseMapper;
import br.com.cwi.resetflix.repository.AtoresRepository;
import br.com.cwi.resetflix.repository.DiretorRepository;
import br.com.cwi.resetflix.repository.FilmeRepository;
import br.com.cwi.resetflix.repository.RegistraVisualizacaoRepository;
import br.com.cwi.resetflix.request.CriarFilmeRequest;
import br.com.cwi.resetflix.response.ConsultarDetalhesFilmeResponse;
import br.com.cwi.resetflix.response.FilmeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class FilmesService {

    @Autowired
    private FilmeRepository filmeRepository;

    @Autowired
    private AtoresRepository atoresRepository;

    @Autowired
    private DiretorRepository diretorRepository;

    @Autowired
    private RegistraVisualizacaoRepository registraVisualizacaoRepository;

    static ConsultarDetalhesFilmeResponseMapper MAPPER_DETALHES_FILME = new ConsultarDetalhesFilmeResponseMapper();
    static FilmeEntityMapper MAPPER_ENTITY = new FilmeEntityMapper();
    static FilmeResponseMapper MAPPER_RESPONSE = new FilmeResponseMapper();

    /**
     * Método que retorna um filme em sua forma detalhada, com todas as informações pertinentes à ele.
     *
     * @param id Parametro usando para localizar o filme.
     * @return Retorna um Objeto com todos o detalhes/informações do filme
     */
    public ConsultarDetalhesFilmeResponse consultarDetalhesFilmePorID(Long id) {

        FilmeEntity filmeSalvo = filmeRepository.acharFilmePorID(id);
        if(Objects.isNull(filmeSalvo)){
            throw new NotFoundException("Filme não encontrado!");
        }

        DiretorEntity diretor = diretorRepository.getDiretorById(filmeSalvo.getIdDiretor());
        if(Objects.isNull(diretor)){
            throw new NotFoundException("Diretor não encontrado!");
        }

        List<AtorEntity> atoresFilme = atoresRepository.acharAtoresByIdFilmes(id);

        return MAPPER_DETALHES_FILME.mapear(filmeSalvo, diretor, atoresFilme);
    }

    /**
     * Método recebe uma requisição(POST) do Controller para adicionar um filme ao repositório.
     *
     * @param request Objeto que será "convertido" em um FilmeEntity, ou seja, em um outro objeto.
     * @return Retorna a ID(Long) criada ao adicionar ao repositório.
     */
    public Long criarFilme(CriarFilmeRequest request) {

        FilmeEntity filmeSalvar = MAPPER_ENTITY.mapear(request);

        return filmeRepository.criarFilme(filmeSalvar);
    }

    /**
     * Método que retorna uma lista de filmes de acordo com o Genero repassado como parametro.
     *
     * @param genero Caso seja nulo(null) retorna a lista toda de filmes.
     * @return Retorna a lista de acordo com o valor recebido por parametro.
     */
    public List<FilmeResponse> getFilmes(Genero genero) {

        if(genero == null) {
            return MAPPER_RESPONSE.mapear(filmeRepository.getFilmes());
        }
        return MAPPER_RESPONSE.mapear(filmeRepository.getFilmes(genero));
    }

    /**
     * Método que registra a visualização de um filme informado pela ID.
     *
     * @param id ID do filme informado para registro.
     */
    public void assistirFilme(Long id) {

        FilmeEntity filmeSalvo = filmeRepository.acharFilmePorID(id);

        if(Objects.isNull(filmeSalvo)) {
            throw new NotFoundException("Filme não encontrado!");
        }

        registraVisualizacaoRepository.assistirFilme(id, filmeSalvo.getGenero());
    }
}
