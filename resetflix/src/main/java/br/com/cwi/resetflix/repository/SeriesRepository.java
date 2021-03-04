package br.com.cwi.resetflix.repository;

import br.com.cwi.resetflix.domain.Genero;
import br.com.cwi.resetflix.entity.SerieEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SeriesRepository {

    private List<SerieEntity> series = new ArrayList<>();
    private Long contadorIds = 1l;

    public Long criarSerie(SerieEntity novaSerie) {

        if(novaSerie.getId() == null) {
            novaSerie.setId(contadorIds++);
        }

        series.add(novaSerie);

        return novaSerie.getId();
    }

    public List<SerieEntity> getSeriesByGenero(Genero genero) {

        List<SerieEntity> seriesByGenero = new ArrayList<>();

        for(SerieEntity serieEntity : series) {
            if(serieEntity.getGenero().equals(genero)) {
                seriesByGenero.add(serieEntity);
            }
        }

        return seriesByGenero;
    }

    public List<SerieEntity> getSeries() {
        return series;
    }
}
