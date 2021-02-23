package br.com.banco.desgraca.domain;

import br.com.banco.desgraca.domain.conta.ContaBancaria;
import br.com.banco.desgraca.domain.conta.TransacaoTipos;
import br.com.banco.desgraca.exception.SaldoInsuficienteException;
import br.com.banco.desgraca.domain.conta.Conta;

public class TipoTransacao {
    //TODO Validar a possibilidade de transformar essa classe em um enumerador.
    private static final TaxasTransacoes CONTA_CORRENTE = TaxasTransacoes.CC;
    private static final TaxasTransacoes CONTA_POUPANCA = TaxasTransacoes.CP;
    private static final TaxasTransacoes CONTA_DIGITAL = TaxasTransacoes.CD;

    private static final TransacaoTipos SAQUE = TransacaoTipos.SAQUE;
    private static final TransacaoTipos DEPOSITO = TransacaoTipos.DEPOSITO;
    private static final TransacaoTipos TRANFERENCIA = TransacaoTipos.TRANFERENCIA;

    public static void transferenciaEntreContas(TaxasTransacoes tipoDeConta, Double valor, ContaBancaria contaOrigem, ContaBancaria contaDestino) {
//        if(valor > (contaOrigem.getSaldo() * (1 + tipoDeConta.getTaxaTranferenciaOutrasInstituicoes()))){
//            throw new SaldoInsuficienteException("Você não Possui Saldo Suficiente para Sacar!!");
//        }
//        contaOrigem.setSaldo(contaOrigem.getSaldo() - (contaOrigem.getSaldo() * tipoDeConta.getTaxaTranferenciaOutrasInstituicoes()));
    }




}
