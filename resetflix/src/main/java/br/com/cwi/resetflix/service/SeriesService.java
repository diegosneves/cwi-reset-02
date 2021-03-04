package br.com.cwi.resetflix.service;

import br.com.cwi.resetflix.domain.Genero;
import br.com.cwi.resetflix.entity.AtorEntity;
import br.com.cwi.resetflix.entity.SerieEntity;
import br.com.cwi.resetflix.mapper.ConsultarDetalhesSeriesReponseMapper;
import br.com.cwi.resetflix.mapper.SerieEntityMapper;
import br.com.cwi.resetflix.mapper.SeriesResponseMapper;
import br.com.cwi.resetflix.repository.AtoresRepository;
import br.com.cwi.resetflix.repository.SeriesRepository;
import br.com.cwi.resetflix.request.CriarSerieRequest;
import br.com.cwi.resetflix.response.ConsultarDetalhesSerieResponse;
import br.com.cwi.resetflix.response.SerieResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SeriesService {

    @Autowired
    private SeriesRepository seriesRepository;

    @Autowired
    private AtoresRepository atoresRepository;

    static SerieEntityMapper MAPPER_ENTITY = new SerieEntityMapper();
    static SeriesResponseMapper MAPPER_RESPONSE = new SeriesResponseMapper();
    static ConsultarDetalhesSeriesReponseMapper MAPPER_DETALHES_RESPONSE = new ConsultarDetalhesSeriesReponseMapper();

    public Long criarSerie(CriarSerieRequest request) {
        return seriesRepository.criarSerie(MAPPER_ENTITY.mapear(request));
    }

    public List<SerieResponse> getSeries(Genero genero) {
        if (genero == null){
            return MAPPER_RESPONSE.mapear(seriesRepository.getSeries());
        }
        return MAPPER_RESPONSE.mapear(seriesRepository.getSeriesByGenero(genero));
    }

    public ConsultarDetalhesSerieResponse getSerieById(Long id) {

        SerieEntity serieEntity = seriesRepository.getSerieById(id);

        List<AtorEntity> atorEntities = new ArrayList<>();

        for (Long idAtor : serieEntity.getIdsAtores()){
            atorEntities.add(atoresRepository.acharAtorPorId(idAtor));
        }

        return MAPPER_DETALHES_RESPONSE.mapear(serieEntity, atorEntities);
    }
}
