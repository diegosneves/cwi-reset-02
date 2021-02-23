package br.com.banco.desgraca.domain.conta;

import br.com.banco.desgraca.domain.InstituicaoBancaria;
import br.com.banco.desgraca.domain.TaxasTransacoes;

import java.time.LocalDate;

public class ContaPoupanca extends Conta{

//    private static final String TIPO_DE_CONTA = "Conta Poupança";
    private static final TaxasTransacoes TIPO_DE_CONTA = TaxasTransacoes.CP;

    public ContaPoupanca(Integer numeroDaConta, InstituicaoBancaria banco) {
        super(numeroDaConta, banco);
    }

    @Override
    public String toString() {
        return String.format("%s %s %s", TIPO_DE_CONTA.getTipoDeConta(), getInstituicaoBancaria().getNome(), getNumeroDaConta());
    }
}
