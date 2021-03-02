package br.com.cwi.resetflix.request;

import java.util.List;

public class CriarDiretorRequest {

    private String nome;
    private List<Long> idFilmes;

    public CriarDiretorRequest(String nome, List<Long> idFilmes) {
        this.nome = nome;
        this.idFilmes = idFilmes;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Long> getIdFilmes() {
        return idFilmes;
    }

    public void setIdFilmes(List<Long> idFilmes) {
        this.idFilmes = idFilmes;
    }
}
