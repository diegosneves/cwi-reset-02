package br.com.cwi.resetflix.web;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import br.com.cwi.resetflix.domain.Genero;
import br.com.cwi.resetflix.request.CriarFilmeRequest;
import br.com.cwi.resetflix.request.CriarSerieRequest;
import br.com.cwi.resetflix.response.ConsultarDetalhesFilmeResponse;
import br.com.cwi.resetflix.response.ConsultarDetalhesSerieResponse;
import br.com.cwi.resetflix.response.FilmeResponse;
import br.com.cwi.resetflix.response.SerieResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

public interface SeriesContract {

    @ApiOperation(value = "Obter todas as séries.", notes = "Obtém todas as séries cadastradas no sistema.")
    public List<SerieResponse> getSeries(
        @ApiParam(name = "genero", value = "Valor Utilizado para filtragem por gênero",
            required = false) Genero genero);

    @ApiOperation(value = "Obter série por ID.", notes = "Obtém detalhes da série baseado no seu identificador.")
    public ConsultarDetalhesSerieResponse getSerieById(@PathVariable("id") final Long id);

    @ApiOperation(value = "Cria uma nova série.", notes = "Cria uma nova série com as informações especificadas.")
    public Long criarSerie(@ApiParam final CriarSerieRequest request);

    @ApiOperation(value = "Obtém recomendações de séries.", notes = "Retorna séries recomendadas para o usuário atual.")
    public List<SerieResponse> getSeries();

    @ApiOperation(value = "Assistir episódio de uma série.", notes = "Assiste o episódio de uma determinada série.")
    public void assistirSerie(@ApiParam("id") final Long id,
        @ApiParam("temporada") final Integer temporada,
        @ApiParam("episodio") final Integer episodio);
}
