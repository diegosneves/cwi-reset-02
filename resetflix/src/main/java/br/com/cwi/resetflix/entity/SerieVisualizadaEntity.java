package br.com.cwi.resetflix.entity;

import br.com.cwi.resetflix.domain.Genero;

public class SerieVisualizadaEntity {

    private Long id;
    private Genero genero;
    private Integer temporadaAtual, episodioAtual;

    public SerieVisualizadaEntity(Long id, Genero genero, Integer temporadaAtual, Integer episodioAtual) {
        this.id = id;
        this.genero = genero;
        this.temporadaAtual = temporadaAtual;
        this.episodioAtual = episodioAtual;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Integer getTemporadaAtual() {
        return temporadaAtual;
    }

    public void setTemporadaAtual(Integer temporadaAtual) {
        this.temporadaAtual = temporadaAtual;
    }

    public Integer getEpisodioAtual() {
        return episodioAtual;
    }

    public void setEpisodioAtual(Integer episodioAtual) {
        this.episodioAtual = episodioAtual;
    }
}
