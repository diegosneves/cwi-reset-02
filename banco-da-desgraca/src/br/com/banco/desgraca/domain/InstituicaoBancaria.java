package br.com.banco.desgraca.domain;

public enum InstituicaoBancaria {
    BANCO_DO_BRASIL("Banco do Brasil"),
    BRADESCO("Bradesco"),
    CAIXA("Caixa Econômica Federal"),
    ITAU("Itaú"),
    NUBANK("Nubank");

    private final String nome;

    InstituicaoBancaria(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
