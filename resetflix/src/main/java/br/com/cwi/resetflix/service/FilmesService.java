package br.com.cwi.resetflix.service;

import br.com.cwi.resetflix.domain.Genero;
import br.com.cwi.resetflix.entity.AtorEntity;
import br.com.cwi.resetflix.entity.DiretorEntity;
import br.com.cwi.resetflix.entity.FilmeEntity;
import br.com.cwi.resetflix.exception.NotFoundException;
import br.com.cwi.resetflix.exception.UsuarioDesocupadoException;
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

import java.util.*;

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

    /**
     *
     * @return
     */
    public List<FilmeResponse> getRecomendacoes() {
        List<FilmeEntity> listaFilmesVisualizados = new ArrayList<>();
        List<FilmeResponse> filmesRecomentadados = new ArrayList<>();
        List<Long> idsFilmesAssistidos = registraVisualizacaoRepository.getIdsFilmesVisualizados();
        Map<Genero, Integer> mapFilmesByGenero = new HashMap<>();

        /*
        Percorre um array que contem uma lista de IDs de filmes assistidos para adicionar os mesmos a um ArrayList<FilmeEntity>.
         */
        for (Long ids : idsFilmesAssistidos) {
            listaFilmesVisualizados.add(filmeRepository.acharFilmePorID(ids));
        }

        /*
        Percorre o array de FilmeEntity mapeando os generos contidos no array e adicionando a um hashmap, incrementando
        mais 1 ao contador.
         */
        for (FilmeEntity filmeEntity : listaFilmesVisualizados) {
            if (mapFilmesByGenero.containsKey(filmeEntity.getGenero())){
                Integer contador = mapFilmesByGenero.get(filmeEntity.getGenero());
                mapFilmesByGenero.put(filmeEntity.getGenero(), ++contador);
            } else {
                mapFilmesByGenero.put(filmeEntity.getGenero(), 1);
            }
        }

        /*
        Percorre um array de FilmeEntity procurando por um valor maior que da variável "maiorValor", ao encontrar atribui o genero
            à variável genero e o valor contido no Map referente ao genero é atribuido à variável valor.
         */
        Genero genero = null;
        Integer maiorValor = 0;
        for (FilmeEntity filmeEntity : listaFilmesVisualizados) {
            if (mapFilmesByGenero.get(filmeEntity.getGenero()) > maiorValor){
                genero = filmeEntity.getGenero();
                maiorValor = mapFilmesByGenero.get(genero);
            }
        }

//        filmesRecomentadados = MAPPER_RESPONSE.mapear(filmeRepository.getFilmes(genero));
        /*
        Verifica se a Lista está vazia e lança uma exception
         */
        if (retornaFilmesNaoAssistidos(filmeRepository.getFilmes(genero), idsFilmesAssistidos).isEmpty()) {
            throw new UsuarioDesocupadoException("Você já assistitu todos os filmes deste genero!!!");
        }
        filmesRecomentadados = MAPPER_RESPONSE.mapear(retornaFilmesNaoAssistidos(filmeRepository.getFilmes(genero), idsFilmesAssistidos));

        return filmesRecomentadados;
    }

    /**
     * Este método recebe uma lista de filmes separadas por generos e uma outra lista de IDs de filmes já visualizados. A lista de ID é usada para encontrar e remover
     *  os filmes já visualizados, devolvendo apenas uma lista de filmes recomendados que não foram assistidos.
     *
     * @param filmes Lista que contem filmes do genero mais assistido pelo o usuario.
     * @param idsFilmesAssistidos Lista contendo os IDs dos filmes já visualizados pelo o usuario.
     * @return Lista contendo todos os filmes do genero preferido não assistidos.
     */
    private List<FilmeEntity> retornaFilmesNaoAssistidos(List<FilmeEntity> filmes, List<Long> idsFilmesAssistidos) {

        /*
        Percorre as listas validando IDs dos Filmes e removendo-os quando encontrado.
         */
        for (FilmeEntity filmeEntity : filmes) {
            for (Long id : idsFilmesAssistidos) {
                if (filmeEntity.getId().equals(id)){
                    filmes.remove(filmeEntity);
                    break;
                }
            }
        }

        return filmes;
    }
}
