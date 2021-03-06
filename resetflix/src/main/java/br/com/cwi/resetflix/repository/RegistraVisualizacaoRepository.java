package br.com.cwi.resetflix.repository;

import br.com.cwi.resetflix.domain.Genero;
import br.com.cwi.resetflix.entity.FilmeVisualizadoEntity;
import br.com.cwi.resetflix.entity.SerieEntity;
import br.com.cwi.resetflix.entity.SerieVisualizadaEntity;
import br.com.cwi.resetflix.exception.BadRequestException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que registra todas as series e filmes assistido pelo usuario.
 */
@Repository
public class RegistraVisualizacaoRepository {

    private List<SerieVisualizadaEntity> series = new ArrayList<>();
    private List<FilmeVisualizadoEntity> filmes = new ArrayList<>();

    /**
     * Este método recebe o ID de um filme e seu genero como parâmetro. Com esses dados, o ArrayList(filmes) e percorrido verificando a
     *          existencia de um objeto(FilmeVisualizadoEntity) de mesmo ID, caso haja, é chamado o método(addVisualizacao) da classe para incrementar um ao atributo
     *          contadorDeVisualizacao existente dentro classe FilmeVisualidadoEntity. No caso da ID estar ausente dentro do ArrayList(filmes), uma nova entity será
     *          adicionado ao ArrayList(filmes).
     *
     * @param id Parâmetro usaddo para busca ou adição de uma entity.
     * @param genero Parâmetro usado para a criação de uma entity.
     */
    public void assistirFilme(Long id, Genero genero) {

        for (FilmeVisualizadoEntity filmeVisualizadoEntity : filmes) {
            if (filmeVisualizadoEntity.getId().equals(id)) {
                filmeVisualizadoEntity.addVisualizacao();
                return;
            }
        }
        filmes.add(new FilmeVisualizadoEntity(id, genero));
    }

    /**
     * Método que recebe dados de uma serie que deseja registra que está sendo assistinda, tendo como parâmetros o ID da serie, temporada e o episódio que irá assistir.
     *  Recebe também uma lista de series que é usada para validações dentro do método.
     *
     * @param id Parâmetro usado para localizar a serie desejada.
     * @param temporada Parâmetro usado para informar a temporada que deseja assistir.
     * @param episodio Parâmetro usado para informar o episódio que deseja assistir.
     * @param seriesList Parâmetro usado para realizar validações.
     */
    public void assitirSerie(Long id, Integer temporada, Integer episodio, List<SerieEntity> seriesList) {

        SerieEntity serieSelecionada = null;

        /*
        Percorre a lista de series para localizar uma serie pelo ID informado por parâmetro, atribuindo o objeto encontrado à uma variável.
         */
        for (SerieEntity serieEntity : seriesList) {
            if (serieEntity.getId().equals(id)) {
                serieSelecionada = serieEntity;
                break;
            }
        }

        /*
        Realiza validações basicas lançando uma exception caso qualquer uma das validações sejam verdadeiras.
        > VERIFICAÇÕES:
            - Verificar se a variável é nula;
            - Verificar se os valores dos parâmetros temporada e episodio estão fora do range da serie selecionada;
         */
        if (serieSelecionada == null || (temporada < 1 || temporada > serieSelecionada.getTemporadas()) ||
                (episodio < 1 || episodio > serieSelecionada.getEpisodios())) {
            throw new BadRequestException();
        }

        /*
        Caso o ArrayList series esteja vazio, adiciona uma nova entity ao ArrayList informando os dados da serie selecionada
            incluindo temporada atual e o episódio atual para registro.
         */
        if(series.isEmpty()) {
            series.add(new SerieVisualizadaEntity(id, serieSelecionada.getGenero(), temporada, episodio));
            return;
        }

        /*
        Percorre o ArrayList buscando a serie selecionada e registrando/atualizando os dados da temporada atual e do episódio atual
         */
        for (SerieVisualizadaEntity serieVisualizadaEntity : series) {
            if (serieVisualizadaEntity.getId().equals(id)) {
                //registrarOndeParou(temporada, episodio, serieVisualizadaEntity);
                serieVisualizadaEntity.setTemporadaAtual(temporada);
                serieVisualizadaEntity.setEpisodioAtual(episodio);
                return;
            }
        }

        /*
        Caso o ArrayList não esteja vazio e não seja encontrado a serie seleciona dentro array, então uma nova entity será adicionada
            ao ArrayList.
         */
        series.add(new SerieVisualizadaEntity(id, serieSelecionada.getGenero(), temporada, episodio));

    }

    /**
     * Este método percorre o ArrayList filmes e coleta as IDs existentes para adicionar a um ArrayList e facilitar
     *  o retorno de um MAPPER_RESPONSE de filmes.
     *
     * @return Retorna um ArrayList do tipo Long
     */
    public List<Long> getIdsFilmesVisualizados() {
        List<Long> idsFilmesVisualizados = new ArrayList<>();

        for (FilmeVisualizadoEntity filmeVisualizadoEntity : filmes) {
            idsFilmesVisualizados.add(filmeVisualizadoEntity.getId());
        }

        return idsFilmesVisualizados;
    }

    /**
     * Percorre o ArrayList<SerieVisualizadaEntity> para coleta da IDs das Series já visualizadas.
     *
     * @return Retorna um ArrayList<Long> com todas as IDs das Séries já visualizadas.
     */
    public List<Long> getIdsSeriesVisualizadas() {
        List<Long> idSeriesVisualizadas = new ArrayList<>();

        for (SerieVisualizadaEntity serieVisualizadaEntity : series) {
            idSeriesVisualizadas.add(serieVisualizadaEntity.getId());
        }
        return idSeriesVisualizadas;
    }
}
