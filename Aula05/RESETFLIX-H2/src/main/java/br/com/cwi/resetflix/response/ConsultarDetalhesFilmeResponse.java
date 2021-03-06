package br.com.cwi.resetflix.response;

import java.util.List;

import br.com.cwi.resetflix.domain.Genero;

public class ConsultarDetalhesFilmeResponse {

    private Long id;
    private String nome;
    private Genero genero;
    private DiretoresResponse diretor;
    private List<AtoresResponse> atores;

    public ConsultarDetalhesFilmeResponse(final Long id, final String nome, final Genero genero,
        final DiretoresResponse diretor, final List<AtoresResponse> atores) {
        this.id = id;
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

    public DiretoresResponse getDiretor() {
        return diretor;
    }

    public void setDiretor(final DiretoresResponse diretor) {
        this.diretor = diretor;
    }

    public List<AtoresResponse> getAtores() {
        return atores;
    }

    public void setAtores(final List<AtoresResponse> atores) {
        this.atores = atores;
    }

}
