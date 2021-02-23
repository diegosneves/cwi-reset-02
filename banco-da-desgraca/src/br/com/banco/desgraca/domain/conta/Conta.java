package br.com.banco.desgraca.domain.conta;

import br.com.banco.desgraca.domain.InstituicaoBancaria;
import br.com.banco.desgraca.domain.Transacao;

import java.util.ArrayList;
import java.util.List;

public abstract class Conta {

    private Integer numeroDaConta;
    private InstituicaoBancaria banco;
    private Double saldo;
    private List<Transacao> transacoes;


    public Conta(Integer numeroDaConta, InstituicaoBancaria banco) {
        this.numeroDaConta = numeroDaConta;
        this.banco = banco;
        this.saldo = 0.0;
        transacoes = new ArrayList<>();
    }

    public Conta(Integer numeroDaConta, InstituicaoBancaria banco, Double saldo) {
        this.numeroDaConta = numeroDaConta;
        this.banco = banco;
        this.saldo = saldo;
        transacoes = new ArrayList<>();
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

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public List<Transacao> getTransacoes() {
        return transacoes;
    }

    public void registraTransacao(Transacao novaTransacao) {
        this.transacoes.add(novaTransacao);
    }

    public void mensagemOperacao(TipoTransacao tipoTransacao) {
        //TODO verificar a necessidade.
    }
}
