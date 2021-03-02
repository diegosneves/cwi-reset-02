package br.com.cwi.resetflix.request;

import java.util.List;

public class CriarAtorRequest {

    private String nome;
    private List<Long> idFilmes;

    public CriarAtorRequest(final String nome, final List<Long> idFilmes) {
        this.nome = nome;
        this.idFilmes = idFilmes;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(final String nome) {
        this.nome = nome;
    }

    public List<Long> getIdFilmes() {
        return idFilmes;
    }

    public void setIdFilmes(final List<Long> idFilmes) {
        this.idFilmes = idFilmes;
    }
}
