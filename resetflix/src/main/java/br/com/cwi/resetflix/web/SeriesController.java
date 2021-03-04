package br.com.cwi.resetflix.web;

import br.com.cwi.resetflix.domain.Genero;
import br.com.cwi.resetflix.request.CriarSerieRequest;
import br.com.cwi.resetflix.response.ConsultarDetalhesSerieResponse;
import br.com.cwi.resetflix.response.SerieResponse;
import br.com.cwi.resetflix.service.SeriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/series")
public class SeriesController implements SeriesContract {

    @Autowired
    private SeriesService seriesService;

    @Override
    @GetMapping
    public List<SerieResponse> getSeries(@RequestParam(value = "genero", required = false) Genero genero) {
        return seriesService.getSeries(genero);
    }

    @Override
    @GetMapping("/{id}")
    public ConsultarDetalhesSerieResponse getSerieById(@PathVariable("id") Long id) {
        return null;
    }

    @Override
    @PostMapping
    public Long criarSerie(@RequestBody CriarSerieRequest request) {
        return seriesService.criarSerie(request);
    }

    @Override
    @GetMapping("/Recomendacoes")
    public List<SerieResponse> getSeriesRecomendadas() {
        return null;
    }

    @Override
    @PostMapping("/{id}/{temporada}/{episodio}/assistir")
    public void assistirSerie(@PathVariable("id/temporada/episodio/") Long id, Integer temporada, Integer episodio) {

    }
}
