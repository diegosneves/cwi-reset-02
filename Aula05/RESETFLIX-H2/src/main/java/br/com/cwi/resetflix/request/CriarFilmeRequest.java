package br.com.cwi.resetflix.request;

import java.util.List;

import br.com.cwi.resetflix.domain.Genero;

public class CriarFilmeRequest {

    private String nome;
    private Long idDiretor;
    private List<Long> idsAtores;
    private Genero genero;

    public CriarFilmeRequest(final String nome, final Long idDiretor, final List<Long> idsAtores, final Genero genero) {
        this.nome = nome;
        this.idDiretor = idDiretor;
        this.idsAtores = idsAtores;
        this.genero = genero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(final String nome) {
        this.nome = nome;
    }

    public Long getIdDiretor() {
        return idDiretor;
    }

    public void setIdDiretor(final Long idDiretor) {
        this.idDiretor = idDiretor;
    }

    public List<Long> getIdsAtores() {
        return idsAtores;
    }

    public void setIdsAtores(final List<Long> idsAtores) {
        this.idsAtores = idsAtores;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(final Genero genero) {
        this.genero = genero;
    }

}
