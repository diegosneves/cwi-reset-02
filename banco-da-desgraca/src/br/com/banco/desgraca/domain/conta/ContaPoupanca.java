package br.com.banco.desgraca.domain.conta;

import br.com.banco.desgraca.domain.InstituicaoBancaria;
import br.com.banco.desgraca.domain.DadosDaContaBancaria;
import br.com.banco.desgraca.domain.OperacoesFinanceiras;
import br.com.banco.desgraca.domain.ValidarAberturaConta;

public class ContaPoupanca extends Conta{

    private static final DadosDaContaBancaria DADOS_DA_CONTA_BANCARIA = DadosDaContaBancaria.CP;

    public ContaPoupanca(Integer numeroDaConta, InstituicaoBancaria banco) {
        super(numeroDaConta, ValidarAberturaConta.validarSuporteTipoDeConta(banco, DADOS_DA_CONTA_BANCARIA));
    }

    @Override
    public void depositar(Double valor) {
        super.depositar(OperacoesFinanceiras.depositarNaConta(valor, this));
    }

    @Override
    public void sacar(Double valor) {
        super.sacar(OperacoesFinanceiras.sacarDinheiro(valor, DADOS_DA_CONTA_BANCARIA, this));
    }

    @Override
    public void transferir(Double valor, ContaBancaria contaDestino) {
        super.transferir(OperacoesFinanceiras.transferenciaEntreContas(DADOS_DA_CONTA_BANCARIA, valor, this, contaDestino), contaDestino);
    }

    @Override
    public String toString() {
        return String.format("%s %s %s", DADOS_DA_CONTA_BANCARIA.getTipoDeConta(), getInstituicaoBancaria().getNome(), getNumeroDaConta());
    }
}
