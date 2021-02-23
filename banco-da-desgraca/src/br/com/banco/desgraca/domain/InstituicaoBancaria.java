package br.com.banco.desgraca.domain;

public enum InstituicaoBancaria {
    BANCO_DO_BRASIL("BANCO DO BRASIL", false, true),
    BRADESCO("BRADESCO", false, true),
    CAIXA("CAIXA ECONÔMICA FEDERAL", false, true),
    ITAU("ITAÚ", true, true),
    NUBANK("NUBANK", true, false);

    private String nome;
    private Boolean aceitaContaDigital, aceitaContaPoupanca;


    InstituicaoBancaria(String nome, Boolean aceitaContaDigital, Boolean aceitaContaPoupanca) {
        this.nome = nome;
        this.aceitaContaDigital = aceitaContaDigital;
        this.aceitaContaPoupanca = aceitaContaPoupanca;
    }

    public String getNome() {
        return nome;
    }

    public Boolean getAceitaContaDigital() {
        return aceitaContaDigital;
    }

    public Boolean getAceitaContaPoupanca() {
        return aceitaContaPoupanca;
    }
}
