package br.com.cwi.resetflix.repository;

import br.com.cwi.resetflix.domain.Genero;
import br.com.cwi.resetflix.entity.SerieEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SeriesRepository {
    //TODO Inserir comentarios

    private List<SerieEntity> series = new ArrayList<>();
    private Long contadorIds = 1l;

    /**
     * Ao receber uma nova entity(parâmetro) verifica se a nova entity está com a ID nula, inserindo o valor do atributo contadorIds
     *          caso seja nulo e incrementando mais um ao atributo contadorIds. Após receber a ID a nova entity é adicionada ao ArrayList.
     *
     * @param novaSerie Objeto que deverá ser adicionado ao ArrayList.
     * @return Retorna o valor do ID
     */
    public Long criarSerie(SerieEntity novaSerie) {

        if(novaSerie.getId() == null) {
            novaSerie.setId(contadorIds++);
        }

        series.add(novaSerie);

        return novaSerie.getId();
    }

    /**
     * Ao receber o parâmetro(genero), o array é percorrido buscando todas as series do mesmo genero e adicionando a uma nova lista.
     *
     * @param genero Parâmetro de busca do método.
     * @return Retorna uma Lista de Series que possuem o mesmo genero repassado com parâmetro.
     */
    public List<SerieEntity> getSeriesByGenero(Genero genero) {

        List<SerieEntity> seriesByGenero = new ArrayList<>();

        for(SerieEntity serieEntity : series) {
            if(serieEntity.getGenero().equals(genero)) {
                seriesByGenero.add(serieEntity);
            }
        }

        return seriesByGenero;
    }

    /**
     * Retorna todos os objetos dentro do ArrayList.
     *
     * @return Retorna a lista atual.
     */
    public List<SerieEntity> getSeries() {
        return series;
    }

    /**
     * Ao receber um ID, verifica a existencia de um objeto com este ID no ArrayList retornando-o.
     *
     * @param id Parâmetro de busca.
     * @return Retorna o objeto de mesma ID ou null caso encontrado.
     */
    public SerieEntity getSerieById(Long id) {
        for (SerieEntity serieEntity : series) {
            if (serieEntity.getId().equals(id)) {
                return serieEntity;
            }
        }
        return null;
    }
}
