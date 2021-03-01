package br.com.cwi.reset.exemploreset;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/nome")
public class NomeController {

    static String nome = "Fulano de Tal";

    @GetMapping
    public String getNome(){
        return this.nome;
    }

    @PutMapping("/{novoNome}")
    public String setNome(@PathVariable String novoNome) {
        this.nome = novoNome;
        return this.getNome();
    }

    @DeleteMapping
    public void deletarNome() {
        this.nome = null;
    }

}
