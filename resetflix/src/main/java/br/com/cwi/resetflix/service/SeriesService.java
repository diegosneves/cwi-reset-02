package br.com.cwi.resetflix.service;

import br.com.cwi.resetflix.domain.Genero;
import br.com.cwi.resetflix.entity.AtorEntity;
import br.com.cwi.resetflix.entity.FilmeEntity;
import br.com.cwi.resetflix.entity.SerieEntity;
import br.com.cwi.resetflix.exception.UsuarioDesocupadoException;
import br.com.cwi.resetflix.mapper.ConsultarDetalhesSeriesReponseMapper;
import br.com.cwi.resetflix.mapper.SerieEntityMapper;
import br.com.cwi.resetflix.mapper.SeriesResponseMapper;
import br.com.cwi.resetflix.repository.AtoresRepository;
import br.com.cwi.resetflix.repository.SeriesRepository;
import br.com.cwi.resetflix.repository.RegistraVisualizacaoRepository;
import br.com.cwi.resetflix.request.CriarSerieRequest;
import br.com.cwi.resetflix.response.ConsultarDetalhesSerieResponse;
import br.com.cwi.resetflix.response.SerieResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SeriesService {

    @Autowired
    private SeriesRepository seriesRepository;

    @Autowired
    private AtoresRepository atoresRepository;

    @Autowired
    private RegistraVisualizacaoRepository registraVisualizacaoRepository;

    static SerieEntityMapper MAPPER_ENTITY = new SerieEntityMapper();
    static SeriesResponseMapper MAPPER_RESPONSE = new SeriesResponseMapper();
    static ConsultarDetalhesSeriesReponseMapper MAPPER_DETALHES_RESPONSE = new ConsultarDetalhesSeriesReponseMapper();

    public Long criarSerie(CriarSerieRequest request) {
        return seriesRepository.criarSerie(MAPPER_ENTITY.mapear(request));
    }

    /**
     * Método que retorna dados de series por genero.
     *
     * @param genero Recebe o genero desejado da serie.
     * @return Retorna as series de acordo com o genero passado como parametro, caso o valor seja nulo(null)
     *  retornara todas a series cadastradas.
     */
    public List<SerieResponse> getSeries(Genero genero) {
        if (genero == null){
            return MAPPER_RESPONSE.mapear(seriesRepository.getSeries());
        }
        return MAPPER_RESPONSE.mapear(seriesRepository.getSeriesByGenero(genero));
    }

    /**
     * Método que retorna os detalhes de uma serie.
     *
     * @param id Parametro para busca da serie desejada.
     * @return Retorna os detalhes da serie.
     */
    public ConsultarDetalhesSerieResponse getSerieById(Long id) {

        SerieEntity serieEntity = seriesRepository.getSerieById(id);

        List<AtorEntity> atorEntities = new ArrayList<>();

        for (Long idAtor : serieEntity.getIdsAtores()){
            atorEntities.add(atoresRepository.acharAtorPorId(idAtor));
        }

        return MAPPER_DETALHES_RESPONSE.mapear(serieEntity, atorEntities);
    }

    /**
     * Método que registra a temporada e o ultimo episodio assistido.
     *
     * @param id ID da serie que deseja registrar.
     * @param temporada Temporada de deseja registrar.
     * @param episodio Episodio que deseja registrar.
     */
    public void assistirSerie(Long id, Integer temporada, Integer episodio) {
        registraVisualizacaoRepository.assitirSerie(id, temporada, episodio, seriesRepository.getSeries());
    }

    /**
     *
     * @return
     */
    public List<SerieResponse> getSeriesRecomendadas() {

        List<SerieEntity> listaSeriesRecomendadas = new ArrayList<>();
        List<SerieEntity> listaSeriesVisualizadas = new ArrayList<>();
        List<Long> idSeriesVisualizadas = registraVisualizacaoRepository.getIdsSeriesVisualizadas();

        Map<Genero, Integer> serieByGeneroMap = new HashMap<>();

        /*
        Adiciona as sries ja visualizadas dentro do ArrayList atraves dos IDs repassado ao repositorio.
         */
        for (Long id : idSeriesVisualizadas) {
            listaSeriesVisualizadas.add(seriesRepository.getSerieById(id));
        }

        serieByGeneroMap = mapearGeneroSeriesVisualizadas(listaSeriesVisualizadas);

        Genero genero = generoMaisVisualizadoDasSeries(listaSeriesVisualizadas, serieByGeneroMap);

        listaSeriesRecomendadas = retornaSerieNaoAssistidos(seriesRepository.getSeriesByGenero(genero), idSeriesVisualizadas);

        /*
        Verifica se a Lista está vazia e lança uma exception
         */
        if (listaSeriesRecomendadas.isEmpty()) {
            throw new UsuarioDesocupadoException("Você já assistitu todas as Séries deste genero!!!");
        }

        return MAPPER_RESPONSE.mapear(listaSeriesRecomendadas);
    }

    /**
     * Método que recebe uma lista de Series de um mesmo tipo de genero e uma lista contendo todos os IDs das Séries já visualizadas, para gerar e retornar
     *  uma nova lista com Séries ainda não visualizadas pelo usuário de acordo com o genero mais assistido.
     *
     * @param seriesByGenero Lista de todas as Séries de um mesmo tipo de Genero.
     * @param idSeriesVisualizadas Lista com todos os IDs das Séries já visualizadas.
     * @return Retorna uma nova lista(Recomendada) de Séries ainda não assistidas pelo usuário de acordo o genero mais assistido do mesmo.
     */
    private List<SerieEntity> retornaSerieNaoAssistidos(List<SerieEntity> seriesByGenero, List<Long> idSeriesVisualizadas) {

        List<SerieEntity> novaListaSeries = new ArrayList<>();
        /*
        Percorre as listas validando IDs das Series e add na nova lista quando encontrado.
         */
        for (SerieEntity serieEntity : seriesByGenero){
            for (Long id : idSeriesVisualizadas) {
                if (!(serieEntity.getId().equals(id))) {
                    novaListaSeries.add(serieEntity);
                    break;
                }
            }
        }

        return novaListaSeries;
    }

    /**
     * Método que recebe uma lista com todas as series visualizas pelo usuário e HashMap que contem os generos(Key).
     * O HashMap é usado para buscar a o genero da Serie mais assitida pelo usuário para determinar o retorno.
     *
     * @param listaSeriesVisualizadas Lista contendo todas a series visualizadas pelo usuário.
     * @param serieByGeneroMap HashMap usado para verificar o genero mais assistido.
     * @return Retorna o Genero mais assistido.
     */
    private Genero generoMaisVisualizadoDasSeries(List<SerieEntity> listaSeriesVisualizadas, Map<Genero, Integer> serieByGeneroMap) {

        /*
        Percorre um array de SerieEntity procurando por um valor maior que da variável "maiorValor", ao encontrar atribui o genero
            à variável genero e o valor contido no Map referente ao genero é atribuido à variável maiorValor.
         */
        Genero genero = null;
        Integer maiorValor = 0;
        for (SerieEntity serieEntity : listaSeriesVisualizadas) {
            if (serieByGeneroMap.get(serieEntity.getGenero()) > maiorValor) {
                genero = serieEntity.getGenero();
                maiorValor = serieByGeneroMap.get(genero);
            }
        }
        return genero;
    }

    /**
     * Método que recebe um lista de Séries já visualizadas pelo usuário para mapear os Generos das Séries e retornar um HashMap.
     *
     * @param listaSeriesVisualizadas Lista com todas as Séries já visualizadas pelo usuário.
     * @return Retorna um HashMap.
     */
    private Map<Genero, Integer> mapearGeneroSeriesVisualizadas(List<SerieEntity> listaSeriesVisualizadas) {

        Map<Genero, Integer> generoIntegerMap = new HashMap<>();

        /*
        Percorre o ArrayList<SerieEntity> mapeando os Generos contidos no array e adicionando a um hashmap, incrementando
        mais 1 ao contador.
         */
        for(SerieEntity serieEntity : listaSeriesVisualizadas) {
            if (generoIntegerMap.containsKey(serieEntity.getGenero())) {
                Integer contador = generoIntegerMap.get(serieEntity.getGenero());
                generoIntegerMap.put(serieEntity.getGenero(), ++contador);
            } else {
                generoIntegerMap.put(serieEntity.getGenero(), 1);
            }
        }
        return generoIntegerMap;
    }
}
