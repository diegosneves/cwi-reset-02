package br.com.banco.desgraca.domain.conta;

import br.com.banco.desgraca.domain.InstituicaoBancaria;
import br.com.banco.desgraca.domain.TaxasTransacoes;

import java.time.LocalDate;

public class ContaDigital extends Conta implements ContaBancaria {

//    private static final String TIPO_DE_CONTA = "Conta Digital";
    private static final TaxasTransacoes TIPO_DE_CONTA = TaxasTransacoes.CD;

    public ContaDigital(Integer numeroDaConta, InstituicaoBancaria banco) {
        super(numeroDaConta, banco);
    }

    @Override
    public InstituicaoBancaria getInstituicaoBancaria() {
        return getInstituicaoBancaria();
    }

    @Override
    public Double consultarSaldo() {
        return null;
    }

    @Override
    public void depositar(Double valor) {

    }

    @Override
    public void sacar(Double valor) {

    }

    @Override
    public void transferir(Double valor, ContaBancaria contaDestino) {

    }

    @Override
    public void exibirExtrato(LocalDate inicio, LocalDate fim) {

    }

    @Override
    public String toString() {
        return String.format("%s %s %s", TIPO_DE_CONTA.getTipoDeConta(), getInstituicaoBancaria().getNome(), getNumeroDaConta());
    }
}
