package br.com.cwi.resetflix.request;

import java.util.List;

public class CriarDiretorRequest {

    private final String nome;
    private final List<Long> idFilmes;

    public CriarDiretorRequest(final String nome, final List<Long> idFilmes) {
        this.nome = nome;
        this.idFilmes = idFilmes;
    }

    public String getNome() {
        return nome;
    }

    public List<Long> getIdFilmes() {
        return idFilmes;
    }
}
