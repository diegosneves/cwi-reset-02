package br.com.cwi.resetflix.entity;

import java.util.List;

public class AtorEntity {

    private Long id;
    private String nome;
    private List<Long> idsFilmes;

    public AtorEntity(final String nome, final List<Long> idsFilmes) {
        this.nome = nome;
        this.idsFilmes = idsFilmes;
    }
    public AtorEntity(final Long id, final String nome, final List<Long> idsFilmes) {
        this.id = id;
        this.nome = nome;
        this.idsFilmes = idsFilmes;
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

    public List<Long> getIdsFilmes() {
        return idsFilmes;
    }

    public void setIdsFilmes(final List<Long> idsFilmes) {
        this.idsFilmes = idsFilmes;
    }
}
