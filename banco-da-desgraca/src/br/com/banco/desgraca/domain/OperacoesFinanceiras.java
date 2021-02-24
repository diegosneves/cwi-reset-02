package br.com.banco.desgraca.domain;

import br.com.banco.desgraca.domain.conta.ContaBancaria;
import br.com.banco.desgraca.exception.SaldoInsuficienteException;
import br.com.banco.desgraca.exception.ValorInvalidoException;

import java.text.DecimalFormat;

public class OperacoesFinanceiras {

    private static final TaxasTransacoes CONTA_CORRENTE = TaxasTransacoes.CC;
    private static final TaxasTransacoes CONTA_POUPANCA = TaxasTransacoes.CP;
    private static final TaxasTransacoes CONTA_DIGITAL = TaxasTransacoes.CD;

    private static final TipoTransacao SAQUE = TipoTransacao.SAQUE;
    private static final TipoTransacao DEPOSITO = TipoTransacao.DEPOSITO;
    private static final TipoTransacao TRANFERENCIA = TipoTransacao.TRANFERENCIA;

    public static Double depositarNaConta(Double valor, ContaBancaria contaOrigem){
        mensagemOperacao(DEPOSITO, valor, contaOrigem);
        return valor;
    }

    public static Double sacarDinheiro(Double valor, TaxasTransacoes tipoDeConta, ContaBancaria contaOrigem){
        if ((valor * (1 + tipoDeConta.getTaxaSaque())) > contaOrigem.consultarSaldo()){
            throw new SaldoInsuficienteException("Você não Possui Saldo Suficiente para Sacar!!");
        }
        if(regrasDeSaque(tipoDeConta, valor)){
            throw new ValorInvalidoException(valorInvalidoMensagem(tipoDeConta));
        }
        mensagemOperacao(SAQUE, valor, contaOrigem);
        return (valor * (1 + tipoDeConta.getTaxaSaque()));
    }

    private static boolean regrasDeSaque(TaxasTransacoes tipoDeConta, Double valor){
        if (tipoDeConta == CONTA_CORRENTE){
            return (valor % CONTA_CORRENTE.getValorMinimoSaque() == 0);
        } else if (tipoDeConta == CONTA_DIGITAL){
            return (valor >= CONTA_DIGITAL.getValorMinimoSaque());
        } else if (tipoDeConta == CONTA_POUPANCA) {
            return (valor >= CONTA_POUPANCA.getValorMinimoSaque());
        } else {
            return false;
        }
    }

    private static String valorInvalidoMensagem(TaxasTransacoes tipoDeConta){
        if(tipoDeConta == CONTA_CORRENTE){
            return String.format("\nO valor Solicitado é inválido!\n" +
                    "Notas disponiveis: \nR$ 5,00 - R$ 10,00 - R$ 20,00 - R$ 50,00 - R$ 100,00 - R$ 200,00\n");
        } else if (tipoDeConta == CONTA_DIGITAL) {
            return String.format("\nO menor dispónivel para saque é de R$ 10,00\n");
        } else if (tipoDeConta == CONTA_POUPANCA) {
            return String.format("\nO menor dispónivel para saque é de R$ 50,00\n");
        } else {
            return String.format("\nValor Inválido!!!\n");
        }
    }

    public static Double transferenciaEntreContas(TaxasTransacoes tipoDeConta, Double valor,
                                                  ContaBancaria contaOrigem, ContaBancaria contaDestino) {
        //FIXME Inserir Comentarios.

        if(contaOrigem.getInstituicaoBancaria() != contaDestino.getInstituicaoBancaria()){
            if((valor * (1 + tipoDeConta.getTaxaTranferenciaOutrasInstituicoes())) > contaOrigem.consultarSaldo()){
                throw new SaldoInsuficienteException("Você não Possui Saldo Suficiente para Sacar!!");
            }
            mensagemOperacao(TRANFERENCIA, valor, contaOrigem, contaDestino);
            contaDestino.depositar(valor);
            return (valor * (1 + tipoDeConta.getTaxaTranferenciaOutrasInstituicoes()));
        } else {
            if(valor > contaOrigem.consultarSaldo()){
                throw new SaldoInsuficienteException("Você não Possui Saldo Suficiente para Sacar!!");
            }
            mensagemOperacao(TRANFERENCIA, valor, contaOrigem, contaDestino);
            contaDestino.depositar(valor);
            return valor;
        }
    }

    private static void mensagemOperacao(TipoTransacao tipoTransacao, Double valor, ContaBancaria contaOrigem) {
        if(tipoTransacao == DEPOSITO){
            System.out.printf("Depositando valor %s na %s\n",
                    DecimalFormat.getCurrencyInstance().format(valor),
                    contaOrigem.toString());
        } else if (tipoTransacao == SAQUE) {
            System.out.printf("Sacando valor %s da %s\n",
                    DecimalFormat.getCurrencyInstance().format(valor),
                    contaOrigem.toString());
        }
    }

    private static void mensagemOperacao(TipoTransacao tipoTransacao, Double valor,
                                         ContaBancaria contaOrigem, ContaBancaria contaDestino) {
        if (tipoTransacao == TRANFERENCIA) {
            System.out.printf("Tranferindo valor %s da %s para %s\n",
                    DecimalFormat.getCurrencyInstance().format(valor),
                    contaOrigem.toString(),
                    contaDestino.toString());

        }
    }




}
