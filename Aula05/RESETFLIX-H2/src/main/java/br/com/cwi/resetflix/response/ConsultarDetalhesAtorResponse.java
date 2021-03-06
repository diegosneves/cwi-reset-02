package br.com.cwi.resetflix.response;

import java.util.List;

public class ConsultarDetalhesAtorResponse {

    private Long id;
    private String nome;
    private List<FilmeResponse> filmes;

    public ConsultarDetalhesAtorResponse(final Long id, final String nome,
        final List<FilmeResponse> filmes) {
        this.id = id;
        this.nome = nome;
        this.filmes = filmes;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(final String nome) {
        this.nome = nome;
    }

    public List<FilmeResponse> getFilmes() {
        return filmes;
    }

    public void setFilmes(final List<FilmeResponse> filmes) {
        this.filmes = filmes;
    }

}
