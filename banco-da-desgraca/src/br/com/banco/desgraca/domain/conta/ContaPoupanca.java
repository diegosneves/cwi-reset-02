package br.com.banco.desgraca.domain.conta;

import br.com.banco.desgraca.domain.InstituicaoBancaria;
import br.com.banco.desgraca.domain.TaxasTransacoes;
import br.com.banco.desgraca.domain.TipoTransacao;
import br.com.banco.desgraca.domain.ValidaBanco;

import java.time.LocalDate;

public class ContaPoupanca extends Conta{

//    private static final String TIPO_DE_CONTA = "Conta Poupança";
    private static final TaxasTransacoes TIPO_DE_CONTA = TaxasTransacoes.CP;

    public ContaPoupanca(Integer numeroDaConta, InstituicaoBancaria banco) {
        super(numeroDaConta, ValidaBanco.validarAberturaDeConta(banco, TIPO_DE_CONTA));
    }

    @Override
    public void depositar(Double valor) {
        super.depositar(TipoTransacao.depositarNaConta(valor, this));
    }

    @Override
    public void sacar(Double valor) {
        super.sacar(TipoTransacao.sacarDinheiro(valor, TIPO_DE_CONTA, this));
    }

    @Override
    public void transferir(Double valor, ContaBancaria contaDestino) {
        super.transferir(TipoTransacao.transferenciaEntreContas(TIPO_DE_CONTA, valor, this, contaDestino), contaDestino);
    }

    @Override
    public String toString() {
        return String.format("%s %s %s", TIPO_DE_CONTA.getTipoDeConta(), getInstituicaoBancaria().getNome(), getNumeroDaConta());
    }
}
