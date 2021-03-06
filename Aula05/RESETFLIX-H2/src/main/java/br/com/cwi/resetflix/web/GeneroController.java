package br.com.cwi.resetflix.web;

import static java.util.Arrays.asList;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cwi.resetflix.domain.Genero;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/genero")
public class GeneroController {

    @GetMapping
    @ApiOperation(value = "Obter todos os gêneros.", notes = "Obtém todos os gêneros cadastrados no sistema.")
    public List<Genero> getGeneros() {
        return asList(Genero.values());
    }
}
