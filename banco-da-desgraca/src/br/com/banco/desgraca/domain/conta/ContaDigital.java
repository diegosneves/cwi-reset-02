package br.com.banco.desgraca.domain.conta;

import br.com.banco.desgraca.domain.InstituicaoBancaria;
import br.com.banco.desgraca.domain.TaxasTransacoes;
import br.com.banco.desgraca.domain.OperacoesFinanceiras;
import br.com.banco.desgraca.domain.ValidaBanco;

public class ContaDigital extends Conta {

    private static final TaxasTransacoes TAXAS_DE_CONTA = TaxasTransacoes.CD;

    public ContaDigital(Integer numeroDaConta, InstituicaoBancaria banco) {
        super(numeroDaConta, ValidaBanco.validarAberturaDeConta(banco, TAXAS_DE_CONTA));
    }

    @Override
    public void depositar(Double valor) {
        super.depositar(OperacoesFinanceiras.depositarNaConta(valor, this));
    }

    @Override
    public void sacar(Double valor) {
        super.sacar(OperacoesFinanceiras.sacarDinheiro(valor, TAXAS_DE_CONTA, this));
    }

    @Override
    public void transferir(Double valor, ContaBancaria contaDestino) {
        super.transferir(OperacoesFinanceiras.transferenciaEntreContas(TAXAS_DE_CONTA, valor, this, contaDestino), contaDestino);
    }

    @Override
    public String toString() {
        return String.format("%s %s %s", TAXAS_DE_CONTA.getTipoDeConta(), getInstituicaoBancaria().getNome(), getNumeroDaConta());
    }
}
