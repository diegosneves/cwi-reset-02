package br.com.cwi.resetflix.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.cwi.resetflix.domain.Genero;

@Entity
@Table(name = "FILMES")
public class FilmeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nome;

    @Column
    @Enumerated(value = EnumType.STRING)
    private Genero genero;

    @ManyToOne
    private DiretorEntity diretor;

    @ManyToMany
    private List<AtorEntity> atores;

    public FilmeEntity() {
    }

    public FilmeEntity(final String nome, final Genero genero, final DiretorEntity diretor,
        final List<AtorEntity> atores) {
        this.nome = nome;
        this.genero = genero;
        this.diretor = diretor;
        this.atores = atores;
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

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(final Genero genero) {
        this.genero = genero;
    }

    public DiretorEntity getDiretor() {
        return diretor;
    }

    public void setDiretor(final DiretorEntity diretor) {
        this.diretor = diretor;
    }

    public List<AtorEntity> getAtores() {
        return atores;
    }

    public void setAtores(final List<AtorEntity> atores) {
        this.atores = atores;
    }
}
