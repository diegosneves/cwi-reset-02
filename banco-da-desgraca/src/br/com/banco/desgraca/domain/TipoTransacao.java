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

    public static Double transferenciaEntreContas(TaxasTransacoes tipoDeConta, Double valor, ContaBancaria contaOrigem, ContaBancaria contaDestino) {
        Double valorAtualizado = 0.0;
        if(contaOrigem.getInstituicaoBancaria() != contaDestino.getInstituicaoBancaria()){
            if((valor * (1 + tipoDeConta.getTaxaTranferenciaOutrasInstituicoes())) > contaOrigem.consultarSaldo()){
                throw new SaldoInsuficienteException("Você não Possui Saldo Suficiente para Sacar!!");
            }
//            ((Conta) contaOrigem).setSaldo(contaOrigem.consultarSaldo() - (valor * (1 + tipoDeConta.getTaxaTranferenciaOutrasInstituicoes())));
            valorAtualizado = valor * (1 + tipoDeConta.getTaxaTranferenciaOutrasInstituicoes());
//            contaOrigem.transferir(valor * (1 + tipoDeConta.getTaxaTranferenciaOutrasInstituicoes()), contaDestino);
            contaDestino.depositar(valor);
            return valorAtualizado;
        } else {
            if(valor > contaOrigem.consultarSaldo()){
                throw new SaldoInsuficienteException("Você não Possui Saldo Suficiente para Sacar!!");
            }
            ((Conta) contaOrigem).setSaldo(contaOrigem.consultarSaldo() - valor);
//            contaOrigem.transferir(valor, contaDestino);
            contaDestino.depositar(valor);
            return valor;
        }
    }




}
