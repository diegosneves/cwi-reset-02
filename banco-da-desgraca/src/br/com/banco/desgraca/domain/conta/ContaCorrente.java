package br.com.banco.desgraca.domain.conta;

import br.com.banco.desgraca.domain.InstituicaoBancaria;
import br.com.banco.desgraca.domain.TaxasTransacoes;
import br.com.banco.desgraca.domain.TipoTransacao;

public class ContaCorrente extends Conta {

//    private static final String TIPO_DE_CONTA = "Conta Corrente";
    private static final TaxasTransacoes TIPO_DE_CONTA = TaxasTransacoes.CC;


    public ContaCorrente(Integer numeroDaConta, InstituicaoBancaria banco) {
        super(numeroDaConta, banco);
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
        //FIXME Retirar os comentarios
//        transferenciaEntreContas(valor,contaDestino);
//        TipoTransacao.transferenciaEntreContas(TIPO_DE_CONTA, valor, this, contaDestino);
        super.transferir(TipoTransacao.transferenciaEntreContas(TIPO_DE_CONTA, valor, this, contaDestino), contaDestino);
    }

    @Override
    public String toString() {
        return String.format("%s %s %s", TIPO_DE_CONTA.getTipoDeConta(), getInstituicaoBancaria().getNome(), getNumeroDaConta());
    }
}
