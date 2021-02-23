package br.com.banco.desgraca.domain.conta;

import br.com.banco.desgraca.Data;
import br.com.banco.desgraca.domain.InstituicaoBancaria;
import br.com.banco.desgraca.domain.Transacao;
import br.com.banco.desgraca.exception.SaldoInsuficienteException;

import java.text.DecimalFormat;
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

//    private void mensagemOperacao(TransacaoTipos transacaoTipos, Double valor) {
//        if(transacaoTipos == TransacaoTipos.DEPOSITO){
//            System.out.printf("Depositando valor %s na %s\n",
//                    DecimalFormat.getCurrencyInstance().format(valor),
//                    this.toString());
//        } else if (transacaoTipos == TransacaoTipos.SAQUE) {
//            System.out.printf("Sacando valor %s da %s\n",
//                    DecimalFormat.getCurrencyInstance().format(valor),
//                    this.toString());
//        } else if (transacaoTipos == TransacaoTipos.TRANFERENCIA) {
//            System.out.printf("Tranferindo valor %s da %s para %s\n",
//                    DecimalFormat.getCurrencyInstance().format(valor),
//                    this.toString());
//        }
//    }
//
//    private void mensagemOperacao(TransacaoTipos transacaoTipos, Double valor, ContaBancaria contaDestino) {
//        if (transacaoTipos == TransacaoTipos.TRANFERENCIA) {
//            System.out.printf("Tranferindo valor %s da %s para %s\n",
//                    DecimalFormat.getCurrencyInstance().format(valor),
//                    this.toString(),
//                    contaDestino.toString());
////            contaDestino.depositar(valor);
//        }
//    }

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
//        mensagemOperacao(TransacaoTipos.DEPOSITO, valor);
        registraTransacao(new Transacao(valor, Data.getDataTransacao(), TransacaoTipos.DEPOSITO));
        setSaldo(this.saldo + valor);
    }

    @Override
    public void sacar(Double valor) {
//        if(valor > this.saldo){
//            throw new SaldoInsuficienteException("Você não Possui Saldo Suficiente para Sacar!!");
//        }
//        mensagemOperacao(TransacaoTipos.SAQUE, valor);
        registraTransacao(new Transacao(valor, Data.getDataTransacao(), TransacaoTipos.SAQUE));
        setSaldo(this.saldo - valor);
    }

    @Override
    public void transferir(Double valor, ContaBancaria contaDestino) {
        //FIXME
//        System.out.println("Verificar saldo:" + saldo);
//        if(valor > this.saldo){
//            throw new SaldoInsuficienteException("Você não Possui Saldo Suficiente para Transferir!!");
//        }
//        mensagemOperacao(TransacaoTipos.TRANFERENCIA, valor);
//        mensagemOperacao(TransacaoTipos.TRANFERENCIA, valor, contaDestino);
        registraTransacao(new Transacao(valor, Data.getDataTransacao(), TransacaoTipos.TRANFERENCIA));
        setSaldo(this.saldo - valor);
    }

    private void historicoTransacao(LocalDate inicio, LocalDate fim) {
        //FIXME
        if (inicio == null && fim == null){
            for(Transacao transacao : getTransacoes()){
                System.out.println(transacao);;
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
