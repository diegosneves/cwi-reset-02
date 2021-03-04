package br.com.cwi.resetflix.mapper;

import br.com.cwi.resetflix.entity.SerieEntity;
import br.com.cwi.resetflix.response.SerieResponse;

import java.util.ArrayList;
import java.util.List;

public class SeriesResponseMapper {

    public List<SerieResponse> mapear(List<SerieEntity> seriesByGenero) {

        List<SerieResponse> serieResponses = new ArrayList<>();

        for (SerieEntity serieEntity : seriesByGenero) {
            serieResponses.add(new SerieResponse(serieEntity.getId(), serieEntity.getNome(), serieEntity.getGenero()));
        }

        return serieResponses;
    }
}
