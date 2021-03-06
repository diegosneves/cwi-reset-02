package br.com.cwi.resetflix.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cwi.resetflix.request.CriarDiretorRequest;
import br.com.cwi.resetflix.response.ConsultarDetalhesDiretorResponse;
import br.com.cwi.resetflix.response.DiretoresResponse;
import br.com.cwi.resetflix.service.DiretoresService;

@RestController
@RequestMapping("/diretores")
public class DiretoresController implements DiretoresContract {

    @Autowired
    private DiretoresService diretoresService;

    @Override
    @GetMapping
    public List<DiretoresResponse> getDiretores() {
        return diretoresService.getDiretores();
    }

    @Override
    @GetMapping("/{id}")
    public ConsultarDetalhesDiretorResponse getDiretorById(@PathVariable("id") final Long id) {
        return diretoresService.consultarDetalhesDiretor(id);
    }

    @Override
    @PostMapping
    public Long criarDiretor(@RequestBody final CriarDiretorRequest request) {
        return diretoresService.criarDiretor(request);
    }
}
