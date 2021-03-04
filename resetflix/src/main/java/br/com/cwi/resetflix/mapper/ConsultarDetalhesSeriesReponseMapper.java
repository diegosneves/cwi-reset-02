package br.com.cwi.resetflix.mapper;

import br.com.cwi.resetflix.entity.AtorEntity;
import br.com.cwi.resetflix.entity.SerieEntity;
import br.com.cwi.resetflix.response.AtoresResponse;
import br.com.cwi.resetflix.response.ConsultarDetalhesSerieResponse;

import java.util.List;

public class ConsultarDetalhesSeriesReponseMapper {

    public ConsultarDetalhesSerieResponse mapear(SerieEntity serieEntity, List<AtorEntity> atorEntities) {

        List<AtoresResponse> atoresResponses = new AtoresResponseMapper().mapear(atorEntities);

        return new ConsultarDetalhesSerieResponse(serieEntity.getId(), serieEntity.getNome(), serieEntity.getGenero(),
                serieEntity.getTemporadas(), serieEntity.getEpisodios(), atoresResponses);
    }
}
