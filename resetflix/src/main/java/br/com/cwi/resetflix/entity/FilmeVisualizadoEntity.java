package br.com.cwi.resetflix.entity;

import br.com.cwi.resetflix.domain.Genero;

public class FilmeVisualizadoEntity {

    private Long id;
    private Genero genero;
    private Integer contadorDeVisualizacao;

    public FilmeVisualizadoEntity(Long id, Genero genero) {
        this.id = id;
        this.genero = genero;
        this.contadorDeVisualizacao = 1;
    }

    public Long getId() {
        return id;
    }

    public void addVisualizacao() {
        this.contadorDeVisualizacao++;
    }

    public Integer getContadorDeVisualizacao() {
        return contadorDeVisualizacao;
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
}
