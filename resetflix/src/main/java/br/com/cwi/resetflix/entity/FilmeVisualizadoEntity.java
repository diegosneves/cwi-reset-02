package br.com.cwi.resetflix.entity;

import br.com.cwi.resetflix.domain.Genero;

/**
 * Classe que tem como objetivo registrar as visualizações de um filme, tendo como atributos o ID, Genero e um
 *  contador de visualizações de um filme.
 *
 */
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

    /**
     * Método que incrementa 1 ao atributo contadorDeVisualizacao quando chamado
     */
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
