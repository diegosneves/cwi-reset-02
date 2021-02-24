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

    /**
     * Método que recebe valores do tipo LocalDate ou valores null e verifica no ArrayList transacoes as datas conforme regras.
     * Caso ambos os parametros sejam null imprime todas as datas do ArrayList.
     * @param inicio Se o valor for null busca a partir da primeira ocorrencia, caso contrario, busca a partir da data informada.
     * @param fim Se o valor for null a busca será até a ultima ocorrencia, caso contrario, a busca será até a data informada.
     */
    private void historicoTransacao(LocalDate inicio, LocalDate fim) {
        if (inicio != null && fim == null) {
            for (Transacao transacao : getTransacoes()) {
                //Ao percorrer o ArrayList verifica se a data de transação é igual ou maior ao do parametro inicio, em caso de posivito imprime o objeto.
                if (transacao.getDataTransacao().isEqual(inicio) || transacao.getDataTransacao().isAfter(inicio)) {
                    System.out.println(transacao);
                }
            }
        } else if (inicio == null && fim != null) {
            for (Transacao transacao : getTransacoes()) {
                //Ao percorrer o ArrayList verifica se a data de transação é igual ou menor ao do parametro fim, em caso de posivito imprime o objeto.
                if (transacao.getDataTransacao().isEqual(fim) || transacao.getDataTransacao().isBefore(fim)) {
                    System.out.println(transacao);
                }
            }
        } else if (inicio != null && fim != null) {
            for (Transacao transacao : getTransacoes()) {
                //Percorre o ArrayList e imprime apenas os valores que estão entre os parâmetros informados(inicio e fim).
                if ((transacao.getDataTransacao().isEqual(inicio) || transacao.getDataTransacao().isAfter(inicio)) &&
                        (transacao.getDataTransacao().isEqual(fim) || transacao.getDataTransacao().isBefore(fim))) {
                    System.out.println(transacao);
                }
            }
        } else {
            //Caso os parâmetros sejam null, imprime todos os valores do ArrayList
            for (Transacao transacao : getTransacoes()) {
                System.out.println(transacao);
            }
        }

    }

    @Override
    public void exibirExtrato(LocalDate inicio, LocalDate fim) {
        System.out.printf("\t----- EXTRATO %s\n", this.toString());
        historicoTransacao(inicio, fim);
        System.out.println("\t-----");
    }

}
