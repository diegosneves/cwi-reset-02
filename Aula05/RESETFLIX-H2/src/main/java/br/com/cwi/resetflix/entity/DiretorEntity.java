package br.com.cwi.resetflix.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "DIRETORES")
public class DiretorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nome;

    @OneToMany(mappedBy = "diretor")
    private List<FilmeEntity> filmes;

    public DiretorEntity() {
    }

    public DiretorEntity(final String nome, final List<FilmeEntity> filmes) {
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

    public List<FilmeEntity> getFilmes() {
        return filmes;
    }

    public void setFilmes(final List<FilmeEntity> filmes) {
        this.filmes = filmes;
    }
}
