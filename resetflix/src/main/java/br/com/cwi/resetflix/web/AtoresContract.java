package br.com.cwi.resetflix.web;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.cwi.resetflix.request.CriarAtorRequest;
import br.com.cwi.resetflix.response.AtoresResponse;
import br.com.cwi.resetflix.response.ConsultarDetalhesAtorResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

public interface AtoresContract {

    @ApiOperation(value = "Obter todos os atores.", notes = "Obtém todos os atores cadastrados no sistema.")
    List<AtoresResponse> getAtores();

    @ApiOperation(value = "Obter ator por ID.", notes = "Obtém detalhes do ator baseado no seu identificador.")
    ConsultarDetalhesAtorResponse getAtorById(@ApiParam("id") final Long id);

    @ApiOperation(value = "Cria um novo ator.", notes = "Cria um novo ator com as informações especificadas.")
    Long criarAtor(@ApiParam final CriarAtorRequest request);
}
