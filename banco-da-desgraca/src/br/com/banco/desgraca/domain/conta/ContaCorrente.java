package br.com.banco.desgraca.domain.conta;

import br.com.banco.desgraca.domain.InstituicaoBancaria;
import br.com.banco.desgraca.domain.TaxasTransacoes;
import br.com.banco.desgraca.exception.SaldoInsuficienteException;

public class ContaCorrente extends Conta {

//    private static final String TIPO_DE_CONTA = "Conta Corrente";
    private static final TaxasTransacoes TIPO_DE_CONTA = TaxasTransacoes.CC;


    public ContaCorrente(Integer numeroDaConta, InstituicaoBancaria banco) {
        super(numeroDaConta, banco);
    }

    private void transferenciaEntreContas(Double valor, ContaBancaria contaDestino){
        //TODO Validar contas diferentes
        if(getInstituicaoBancaria() != contaDestino.getInstituicaoBancaria()){
            if(valor > (getSaldo() * (1 + TIPO_DE_CONTA.getTaxaTranferenciaOutrasInstituicoes()))){
                throw new SaldoInsuficienteException("Você não Possui Saldo Suficiente para Sacar!!");
            }
            setSaldo(getSaldo() - (getSaldo() * TIPO_DE_CONTA.getTaxaTranferenciaOutrasInstituicoes()));
        } else {
            if(valor > getSaldo()){
                throw new SaldoInsuficienteException("Você não Possui Saldo Suficiente para Sacar!!");
            }
        }

    }

    @Override
    public void transferir(Double valor, ContaBancaria contaDestino) {
        transferenciaEntreContas(valor,contaDestino);
        super.transferir(valor, contaDestino);
    }

    @Override
    public String toString() {
        return String.format("%s %s %s", TIPO_DE_CONTA.getTipoDeConta(), getInstituicaoBancaria().getNome(), getNumeroDaConta());
    }
}
