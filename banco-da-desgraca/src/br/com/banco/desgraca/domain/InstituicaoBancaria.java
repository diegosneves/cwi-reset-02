package br.com.banco.desgraca.domain;

public enum InstituicaoBancaria {
    BANCO_DO_BRASIL("Banco do Brasil", false, true),
    BRADESCO("Bradesco", false, true),
    CAIXA("Caixa Econômica Federal", false, true),
    ITAU("Itaú", true, true),
    NUBANK("Nubank", true, false);

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
