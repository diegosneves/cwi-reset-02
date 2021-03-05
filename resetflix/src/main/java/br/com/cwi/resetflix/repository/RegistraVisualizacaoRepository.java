package br.com.cwi.resetflix.repository;

import br.com.cwi.resetflix.domain.Genero;
import br.com.cwi.resetflix.entity.FilmeVisualizadoEntity;
import br.com.cwi.resetflix.entity.SerieEntity;
import br.com.cwi.resetflix.entity.SerieVisualizadaEntity;
import br.com.cwi.resetflix.exception.BadRequestException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RegistraVisualizacaoRepository {

    private List<SerieVisualizadaEntity> series = new ArrayList<>();
    private List<FilmeVisualizadoEntity> filmes = new ArrayList<>();

    public void assistirFilme(Long id, Genero genero) {

        for (FilmeVisualizadoEntity filmeVisualizadoEntity : filmes) {
            if (filmeVisualizadoEntity.getId().equals(id)) {
                filmeVisualizadoEntity.addVisualizacao();
                return;
            }
        }
        filmes.add(new FilmeVisualizadoEntity(id, genero));
    }

    public void assitirSerie(Long id, Integer temporada, Integer episodio, List<SerieEntity> seriesList) {

        SerieEntity serieSelecionada = null;

        for (SerieEntity serieEntity : seriesList) {
            if (serieEntity.getId().equals(id)) {
                serieSelecionada = serieEntity;
                break;
            }
        }

        if (serieSelecionada == null || (temporada < 1 || temporada > serieSelecionada.getTemporadas()) ||
                (episodio < 1 || episodio > serieSelecionada.getEpisodios())) {
            throw new BadRequestException();
        }

        if(series.isEmpty()) {
            series.add(new SerieVisualizadaEntity(id, serieSelecionada.getGenero(), temporada, episodio));
            return;
        }

        for (SerieVisualizadaEntity serieVisualizadaEntity : series) {
            if (serieVisualizadaEntity.getId().equals(id)) {
                registrarOndeParou(temporada, episodio, serieVisualizadaEntity);
                return;
            }
        }

    }

    private void registrarOndeParou(Integer temporada, Integer episodio, SerieVisualizadaEntity serieVisualizadaEntity) {
        serieVisualizadaEntity.setTemporadaAtual(temporada);
        serieVisualizadaEntity.setEpisodioAtual(episodio);
    }

}
