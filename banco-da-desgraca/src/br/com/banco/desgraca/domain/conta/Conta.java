package br.com.banco.desgraca.domain.conta;

import br.com.banco.desgraca.Data;
import br.com.banco.desgraca.domain.InstituicaoBancaria;
import br.com.banco.desgraca.domain.TipoTransacao;
import br.com.banco.desgraca.domain.Transacao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Conta implements ContaBancaria {

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

    public void setBanco(InstituicaoBancaria banco) {
        this.banco = banco;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    private List<Transacao> getTransacoes() {
        return transacoes;
    }

    private void registraTransacao(Transacao novaTransacao) {
        this.transacoes.add(novaTransacao);
    }

    @Override
    public InstituicaoBancaria getInstituicaoBancaria() {
        return this.banco;
    }

    @Override
    public Double consultarSaldo() {
        return this.saldo;
    }

    @Override
    public void depositar(Double valor) {
        registraTransacao(new Transacao(valor, Data.getDataTransacao(), TipoTransacao.DEPOSITO));
        setSaldo(this.saldo + valor);
    }

    @Override
    public void sacar(Double valor) {
        registraTransacao(new Transacao(valor, Data.getDataTransacao(), TipoTransacao.SAQUE));
        setSaldo(this.saldo - valor);
    }

    @Override
    public void transferir(Double valor, ContaBancaria contaDestino) {
        registraTransacao(new Transacao(valor, Data.getDataTransacao(), TipoTransacao.TRANFERENCIA));
        setSaldo(this.saldo - valor);
    }

    private void historicoTransacao(LocalDate inicio, LocalDate fim) {
        //FIXME
        if (inicio != null && fim == null) {
            //TODO
            for (Transacao transacao : getTransacoes()) {
                if (transacao.getDataTransacao().isEqual(inicio) || transacao.getDataTransacao().isAfter(inicio)) {
                    System.out.println(transacao);
                }
            }
        } else if (inicio == null && fim != null) {
            //TODO
            for (Transacao transacao : getTransacoes()) {
                if (transacao.getDataTransacao().isEqual(fim) || transacao.getDataTransacao().isBefore(fim)) {
                    System.out.println(transacao);
                }
            }
        } else if (inicio != null && fim != null) {
            for (Transacao transacao : getTransacoes()) {
                if ((transacao.getDataTransacao().isEqual(inicio) || transacao.getDataTransacao().isAfter(inicio)) &&
                        (transacao.getDataTransacao().isEqual(fim) || transacao.getDataTransacao().isBefore(fim))) {
                    System.out.println(transacao);
                }
            }
        } else {
            for (Transacao transacao : getTransacoes()) {
                System.out.println(transacao);
            }
        }

    }

    @Override
    public void exibirExtrato(LocalDate inicio, LocalDate fim) {
        //FIXME
        System.out.printf("\t----- EXTRATO %s\n", this.toString());
        historicoTransacao(inicio, fim);
        System.out.println("\t-----");
    }

}
