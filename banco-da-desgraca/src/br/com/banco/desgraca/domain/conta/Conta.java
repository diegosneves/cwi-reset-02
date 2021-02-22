package br.com.banco.desgraca.domain.conta;

import br.com.banco.desgraca.domain.InstituicaoBancaria;

public abstract class Conta {

    private Integer numeroDaConta;
    private InstituicaoBancaria banco;

    public Conta(Integer numeroDaConta, InstituicaoBancaria banco) {
        this.numeroDaConta = numeroDaConta;
        this.banco = banco;
    }

    public Integer getNumeroDaConta() {
        return numeroDaConta;
    }

    public void setNumeroDaConta(Integer numeroDaConta) {
        this.numeroDaConta = numeroDaConta;
    }

    public InstituicaoBancaria getBanco() {
        return banco;
    }

    public void setBanco(InstituicaoBancaria banco) {
        this.banco = banco;
    }
}
