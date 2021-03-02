package br.com.cwi.resetflix.response;

import java.util.List;

public class ConsultarDetalhesDiretorResponse {

    Long id;
    String nome;
    List<FilmeResponse> filmes;

    public ConsultarDetalhesDiretorResponse(Long id, String nome, List<FilmeResponse> filmes) {
        this.id = id;
        this.nome = nome;
        this.filmes = filmes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<FilmeResponse> getFilmes() {
        return filmes;
    }

    public void setFilmes(List<FilmeResponse> filmes) {
        this.filmes = filmes;
    }
}
