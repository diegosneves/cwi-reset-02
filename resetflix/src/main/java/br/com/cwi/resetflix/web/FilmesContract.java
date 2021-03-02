package br.com.cwi.resetflix.web;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.cwi.resetflix.domain.Genero;
import br.com.cwi.resetflix.request.CriarAtorRequest;
import br.com.cwi.resetflix.request.CriarFilmeRequest;
import br.com.cwi.resetflix.response.AtoresResponse;
import br.com.cwi.resetflix.response.ConsultarDetalhesAtorResponse;
import br.com.cwi.resetflix.response.ConsultarDetalhesFilmeResponse;
import br.com.cwi.resetflix.response.FilmeResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

public interface FilmesContract {

    @ApiOperation(value = "Obter todos os filmes.", notes = "Obtém todos os filmes cadastrados no sistema.")
    List<FilmeResponse> getFilmes(
        @ApiParam(name = "genero", value = "Valor Utilizado para filtragem por gênero",
            required = false) Genero genero);

    @ApiOperation(value = "Obter filme por ID.", notes = "Obtém detalhes do filme baseado no seu identificador.")
    ConsultarDetalhesFilmeResponse getFilmeById(@PathVariable("id") final Long id);

    @ApiOperation(value = "Cria um novo filme.", notes = "Cria um novo filme com as informações especificadas.")
    Long criarFilme(@ApiParam final CriarFilmeRequest request);

    @ApiOperation(value = "Obtém recomendações de filmes.", notes = "Retorna filmes recomendados para o usuário atual.")
    List<FilmeResponse> getRecomendacoesFilmes();

    @ApiOperation(value = "Assistir filme.", notes = "Assiste um determinado filme.")
    public void assistirFilme(@ApiParam("id") final Long id);
}
