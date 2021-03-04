package br.com.cwi.resetflix.mapper;

import br.com.cwi.resetflix.entity.SerieEntity;
import br.com.cwi.resetflix.request.CriarSerieRequest;

public class SerieEntityMapper {

    public SerieEntity mapear(CriarSerieRequest request) {
        return new SerieEntity(request.getNome(), request.getGenero(), request.getTemporadas(), request.getEpisodios(), request.getIdsAtores());
    }
}
