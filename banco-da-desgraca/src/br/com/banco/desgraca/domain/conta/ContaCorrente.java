package br.com.banco.desgraca.domain.conta;

import br.com.banco.desgraca.Data;
import br.com.banco.desgraca.domain.InstituicaoBancaria;
import br.com.banco.desgraca.domain.TaxasTransacoes;
import br.com.banco.desgraca.domain.Transacao;
import br.com.banco.desgraca.exception.SaldoInsuficienteException;

import java.text.DecimalFormat;
import java.time.LocalDate;

public class ContaCorrente extends Conta implements ContaBancaria {

//    private static final String TIPO_DE_CONTA = "Conta Corrente";
    private static final TaxasTransacoes TIPO_DE_CONTA = TaxasTransacoes.CC;


    public ContaCorrente(Integer numeroDaConta, InstituicaoBancaria banco) {
        super(numeroDaConta, banco);
    }

    @Override
    public InstituicaoBancaria getInstituicaoBancaria() {
        return getBanco();
    }

    @Override
    public Double consultarSaldo() {
        return getSaldo();
    }

    @Override
    public void depositar(Double valor) {
        System.out.printf("Depositando valor %s na %s\n",
                DecimalFormat.getCurrencyInstance().format(valor),
                this.toString());
        registraTransacao(new Transacao(valor, Data.getDataTransacao(), TipoTransacao.DEPOSITO));
        setSaldo(getSaldo() + valor);
    }

    @Override
    public void sacar(Double valor) {
        if(valor > getSaldo()){
            throw new SaldoInsuficienteException("Você não Possui Saldo Suficiente para Sacar!!");
        }
        System.out.printf("Sacando valor %s da %s\n",
                DecimalFormat.getCurrencyInstance().format(valor),
                this.toString());

        registraTransacao(new Transacao(valor, Data.getDataTransacao(), TipoTransacao.SAQUE));
        setSaldo(getSaldo() - valor);
    }

    @Override
    public void transferir(Double valor, ContaBancaria contaDestino) {
        //FIXME
        if(valor > getSaldo()){
            throw new SaldoInsuficienteException("Você não Possui Saldo Suficiente para Transferir!!");
        }
        registraTransacao(new Transacao(valor, Data.getDataTransacao(), TipoTransacao.TRANFERENCIA));
        setSaldo(getSaldo() - valor);
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

    @Override
    public String toString() {
        return String.format("%s %s %s", TIPO_DE_CONTA.getTipoDeConta(), getInstituicaoBancaria().getNome(), getNumeroDaConta());
    }
}
