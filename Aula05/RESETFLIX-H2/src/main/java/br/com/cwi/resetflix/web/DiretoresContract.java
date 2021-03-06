package br.com.cwi.resetflix.web;

import java.util.List;

import br.com.cwi.resetflix.request.CriarAtorRequest;
import br.com.cwi.resetflix.request.CriarDiretorRequest;
import br.com.cwi.resetflix.response.AtoresResponse;
import br.com.cwi.resetflix.response.ConsultarDetalhesAtorResponse;
import br.com.cwi.resetflix.response.ConsultarDetalhesDiretorResponse;
import br.com.cwi.resetflix.response.DiretoresResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

public interface DiretoresContract {

    @ApiOperation(value = "Obter todos os diretores.", notes = "Obtém todos os diretores cadastrados no sistema.")
    List<DiretoresResponse> getDiretores();

    @ApiOperation(value = "Obter diretor por ID.", notes = "Obtém detalhes do diretor baseado no seu identificador.")
    public ConsultarDetalhesDiretorResponse getDiretorById(@ApiParam("id") final Long id);

    @ApiOperation(value = "Cria um novo diretor.", notes = "Cria um novo diretor com as informações especificadas.")
    public Long criarDiretor(@ApiParam final CriarDiretorRequest request);
}
