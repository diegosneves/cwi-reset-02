package br.com.cwi.resetflix.web;

import br.com.cwi.resetflix.request.CriarDiretorRequest;
import br.com.cwi.resetflix.response.ConsultarDetalhesDiretorResponse;
import br.com.cwi.resetflix.response.DiretoresResponse;
import br.com.cwi.resetflix.service.DiretoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ConsultarDetalhesDiretorResponse getDiretorById(@PathVariable("id") Long id) {
        return diretoresService.consultarDetalhesDiretor(id);
    }

    @Override
    @PostMapping
    public Long criarDiretor(@RequestBody CriarDiretorRequest request) {
        return diretoresService.criarDiretor(request);
    }
}
