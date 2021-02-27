package br.com.banco.desgraca.domain;

import br.com.banco.desgraca.domain.conta.ContaBancaria;
import br.com.banco.desgraca.domain.conta.ContaDigital;
import br.com.banco.desgraca.domain.conta.ContaPoupanca;
import br.com.banco.desgraca.exception.SaldoInsuficienteException;
import br.com.banco.desgraca.exception.ValorInvalidoException;

import java.text.DecimalFormat;

/**
 * Classe que contém métodos static para apoiar a classe Conta e facilitar as operações.
 */
public class OperacoesFinanceiras {

    private static final DadosDaContaBancaria CONTA_CORRENTE = DadosDaContaBancaria.CONTA_CORRENTE;
    private static final DadosDaContaBancaria CONTA_POUPANCA = DadosDaContaBancaria.CONTA_POUPANCA;
    private static final DadosDaContaBancaria CONTA_DIGITAL = DadosDaContaBancaria.CONTA_DIGITAL;

    private static final TipoTransacao SAQUE = TipoTransacao.SAQUE;
    private static final TipoTransacao DEPOSITO = TipoTransacao.DEPOSITO;
    private static final TipoTransacao TRANFERENCIA = TipoTransacao.TRANFERENCIA;

    /**
     * Método que recebe os dados do deposito e imprime a mensagem na tela com informações da operação financeira, retornando o valor para registro.
     *
     * @param valor Valor à ser depositado.
     * @param contaOrigem Conta Bancaria que receberá o valor.
     * @return O valor à ser depositado.
     */
    public static Double depositarNaConta(Double valor, ContaBancaria contaOrigem){
        mensagemOperacao(DEPOSITO, valor, contaOrigem);
        return valor;
    }

    /**
     * Método que recebe dados para saque e imprime uma mensagem na tela com informações da operação financeira, retornando o valor para registro.
     *
     * @param valor Valor do saque.
     * @param taxasDaConta Enumerador que contém as informações das taxas de transações de acordo com o tipo de conta (Conta Corrente, Conta Digital ou Conta Poupança).
     * @param contaOrigem Conta Bancaria que irá efetuar o saque.
     * @return Valor à ser sacado.
     */
    public static Double sacarDinheiro(Double valor, DadosDaContaBancaria taxasDaConta, ContaBancaria contaOrigem){

        //Verifica se o valor do saque mais as taxas são maiores que o saldo da conta, se sim, lança uma exception
        if ((valor * (1 + taxasDaConta.getTaxaSaque())) > contaOrigem.consultarSaldo()){
            throw new SaldoInsuficienteException("\nVocê não Possui Saldo Suficiente para Saque!!\n");
        }

        //Verifica se o valor do saque solicitado está de acordo com as regras de saque de cada tipo de conta(Conta Corrente, Conta Digital ou Conta Poupança)
        //Caso negativo, lança uma exception
        if(regrasDeSaque(taxasDaConta, valor)){
            throw new ValorInvalidoException(valorInvalidoMensagem(taxasDaConta));
        }
        mensagemOperacao(SAQUE, valor, contaOrigem);
        return (valor * (1 + taxasDaConta.getTaxaSaque()));
    }

    /**
     * Método que verifica as regras de saque de acordo com cada tipo de conta(Conta Corrente, Conta Digital ou Conta Poupança)
     *
     * @param taxasDaConta Enumerador que contém as informações de valor minimo de saque de acordo com cada tipo de conta(Conta Corrente, Conta Digital ou Conta Poupança).
     * @param valor Valor de saque solicitado;
     * @return Retorna um boolean (true - para invalidar a operação | false - para validar a operação).
     */
    private static boolean regrasDeSaque(DadosDaContaBancaria taxasDaConta, Double valor){
        if (taxasDaConta.equals(CONTA_CORRENTE)){
            return !(valor % CONTA_CORRENTE.getValorMinimoSaque() == 0);
        } else if (taxasDaConta.equals(CONTA_DIGITAL)){
            return !(valor >= CONTA_DIGITAL.getValorMinimoSaque());
        } else if (taxasDaConta.equals(CONTA_POUPANCA)) {
            return !(valor >= CONTA_POUPANCA.getValorMinimoSaque());
        } else {
            return true;
        }
    }

    /**
     * Método usado para personalizar as mensagens recebidas pela classe ValorInvalidoException()
     *
     * @param taxasDaConta Enumerador que contém as informações de valor minimo de saque de acordo com cada tipo de conta(Conta Corrente, Conta Digital ou Conta Poupança).
     * @return Retorna uma String contendo a mensagem de erro de acorodo com cada tipo de conta(Conta Corrente, Conta Digital ou Conta Poupança).
     */
    private static String valorInvalidoMensagem(DadosDaContaBancaria taxasDaConta){
        if(taxasDaConta.equals(CONTA_CORRENTE)){
            return String.format("\nO valor Solicitado é inválido!\n" +
                    "Notas disponiveis: \nR$ 5,00 - R$ 10,00 - R$ 20,00 - R$ 50,00 - R$ 100,00 - R$ 200,00\n");
        } else if (taxasDaConta.equals(CONTA_DIGITAL)) {
            return String.format("\nO menor valor dispónivel para saque é de R$ 10,00\n");
        } else if (taxasDaConta.equals(CONTA_POUPANCA)) {
            return String.format("\nO menor valor dispónivel para saque é de R$ 50,00\n");
        } else {
            return String.format("\nValor Inválido!!!\n");
        }
    }

    /**
     * Método que recebe dados para transferencia e imprime uma mensagem na tela com informações da operação financeira, retornando o valor para registro.
     *
     * @param taxasDaConta Enumerador que contém as informações das taxas de transferencias(Contas mesmo banco | Contas outros bancos)
     *                     de acordo com cada tipo de conta(Conta Corrente, Conta Digital ou Conta Poupança).
     * @param valor Valor à ser transferido.
     * @param contaOrigem Conta de origem da transferencia(De onde está saindo o dinheiro transferido).
     * @param contaDestino Conta de destino da transferencia(Onde está entrando o dinheiro transferido).
     * @return Retorna o valor de transferencia para registro.
     */
    public static Double transferenciaEntreContas(DadosDaContaBancaria taxasDaConta, Double valor,
                                                  ContaBancaria contaOrigem, ContaBancaria contaDestino) {
        //Verifica se a conta de origem e conta de destino são ou não da mesma instituição bancaria.
        if (contaOrigem instanceof ContaDigital){
            //Verifica se o valor de transferencia é maior que o saldo disponivel da conta de origem. Caso positivo lança uma exception.
            if(valor > contaOrigem.consultarSaldo()){
                throw new SaldoInsuficienteException("\nVocê não Possui Saldo Suficiente para Transferencia!!\n");
            }
            mensagemOperacao(TRANFERENCIA, valor, contaOrigem, contaDestino);
            contaDestino.depositar(valor); //Deposita o valor da transferencia na conta de destino.
            return valor; //Retorna o valor para registro.
        }

        if(contaOrigem.getInstituicaoBancaria() != contaDestino.getInstituicaoBancaria()){

            //Para Instituições Bancarias diferentes.
            //Verifica se o valor mais taxas de transferencia é maior que o saldo disponivel da conta de origem. Caso positivo lança uma exception.
            if((valor * (1 + taxasDaConta.getTaxaTranferenciaOutrasInstituicoes())) > contaOrigem.consultarSaldo()){
                throw new SaldoInsuficienteException("\nVocê não Possui Saldo Suficiente para Transferencia!!\n");
            }
            mensagemOperacao(TRANFERENCIA, valor, contaOrigem, contaDestino);
            contaDestino.depositar(valor); //Deposita o valor da transferencia na conta de destino.
            return (valor * (1 + taxasDaConta.getTaxaTranferenciaOutrasInstituicoes())); //Retorna o valor mais taxas para registro.

        } else {

            if (contaOrigem instanceof ContaPoupanca) {
                //Verifica se o valor mais taxas de transferencia é maior que o saldo disponivel da conta de origem. Caso positivo lança uma exception.
                if((valor * (1 + taxasDaConta.getTaxaTranferenciaMesmaInstituicao()) > contaOrigem.consultarSaldo())){
                    throw new SaldoInsuficienteException("\nVocê não Possui Saldo Suficiente para Transferencia!!\n");
                }
                mensagemOperacao(TRANFERENCIA, valor, contaOrigem, contaDestino);
                contaDestino.depositar(valor); //Deposita o valor da transferencia na conta de destino.
                return (valor * (1 + taxasDaConta.getTaxaTranferenciaMesmaInstituicao())); //Retorna o valor mais taxas para registro.
            }

            //Para Instituições Bancarias iguais.
            //Verifica se o valor de transferencia é maior que o saldo disponivel da conta de origem. Caso positivo lança uma exception.
            if(valor > contaOrigem.consultarSaldo()){
                throw new SaldoInsuficienteException("\nVocê não Possui Saldo Suficiente para Transferencia!!\n");
            }
            mensagemOperacao(TRANFERENCIA, valor, contaOrigem, contaDestino);
            contaDestino.depositar(valor); //Deposita o valor da transferencia na conta de destino.
            return valor; //Retorna o valor para registro.
        }
    }

    /**
     * Método usado para imprimir na tela as informações das operações financeiras de acordo com o tipo de transação.
     *
     * @param tipoTransacao Tipo de transação financeira (Depóstio, Saque ou Transferencia).
     * @param valor Valor da operação realizada.
     * @param contaOrigem Conta Bancaria que está efetuando a operação financeira.
     */
    private static void mensagemOperacao(TipoTransacao tipoTransacao, Double valor, ContaBancaria contaOrigem) {
        if(tipoTransacao.equals(DEPOSITO)){
            System.out.printf("Depositando valor %s na %s\n",
                    DecimalFormat.getCurrencyInstance().format(valor),
                    contaOrigem.toString());
        } else if (tipoTransacao.equals(SAQUE)) {
            System.out.printf("Sacando valor %s da %s\n",
                    DecimalFormat.getCurrencyInstance().format(valor),
                    contaOrigem.toString());
        }
    }

    /**
     * Sobrecarga do método usado para imprimir na tela as informações das operações financeiras de acordo com o tipo de transação.
     *
     * @param tipoTransacao Tipo de transação financeira (Depóstio, Saque ou Transferencia).
     * @param valor Valor da operação realizada.
     * @param contaOrigem Conta Bancaria que está efetuando a operação financeira.
     * @param contaDestino Conta Bancaria que está recebendo o valor da operação financeira.
     */
    private static void mensagemOperacao(TipoTransacao tipoTransacao, Double valor,
                                         ContaBancaria contaOrigem, ContaBancaria contaDestino) {
        if (tipoTransacao.equals(TRANFERENCIA)) {
            System.out.printf("Tranferindo valor %s da %s para %s\n",
                    DecimalFormat.getCurrencyInstance().format(valor),
                    contaOrigem.toString(),
                    contaDestino.toString());

        }
    }

}
