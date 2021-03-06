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
        return seriesService.getSerieById(id);
    }

    @Override
    @PostMapping
    public Long criarSerie(@RequestBody CriarSerieRequest request) {
        return seriesService.criarSerie(request);
    }

    @Override
    @GetMapping("/recomendacoes")
    public List<SerieResponse> getSeriesRecomendadas() {
        return seriesService.getSeriesRecomendadas();
    }

    @Override
    @PostMapping("/{id}/{temporada}/{episodio}/assistir")
    public void assistirSerie(@PathVariable Long id, @PathVariable Integer temporada, @PathVariable Integer episodio) {
        seriesService.assistirSerie(id, temporada, episodio);
    }
}
