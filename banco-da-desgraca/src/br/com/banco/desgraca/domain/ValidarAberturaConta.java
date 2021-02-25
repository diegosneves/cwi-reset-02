package br.com.banco.desgraca.domain;

import br.com.banco.desgraca.exception.InstituicaoBancariaInvalidaException;

/**
 * Classe ValidaBanco - Verifica conforme as regras de negócio se a Instituição Financeira presta suporte ao tipo de conta:
 * Conta Corrente;
 * Conta Digital;
 * Conta Poupança;
 */
public class ValidarAberturaConta {

    private static final DadosDaContaBancaria CONTA_POUPANCA = DadosDaContaBancaria.CP;
    private static final DadosDaContaBancaria CONTA_DIGITAL = DadosDaContaBancaria.CD;

    /**
     * Método Static usado para verificar se o banco(Instituição Bancaria) presta suporte para o tipo de conta passado
     * como parametro(Conta Corrente, Conta Digital ou Conta Poupança).
     *
     * @param banco Instituição Bancaria no qual deseja abrir a conta.
     * @param dadosDaContaBancaria Dados da conta(Conta Corrente, Conta Digital ou Conta Poupança) que deseja criar.
     * @return Retorna o banco(Instituição Bancaria) caso as condições sejam satisfeitas conforme as regras de negócio.
     */
    public static InstituicaoBancaria validarSuporteTipoDeConta(InstituicaoBancaria banco, DadosDaContaBancaria dadosDaContaBancaria){
        if (dadosDaContaBancaria.equals(CONTA_DIGITAL)){
            if(banco.getAceitaContaDigital()){
                return banco;
            } else {
                throw new InstituicaoBancariaInvalidaException(String.format("\nInfelizmente o banco %s não tem Suporte para uma %s!!\n",
                        banco.getNome(),
                        dadosDaContaBancaria.getTipoDeConta()));
            }
        } else if (dadosDaContaBancaria.equals(CONTA_POUPANCA)) {
            if(banco.getAceitaContaPoupanca()){
                return banco;
            } else {
                throw new InstituicaoBancariaInvalidaException(String.format("\nInfelizmente o banco %s não tem Suporte para uma %s!!\n",
                        banco.getNome(),
                        dadosDaContaBancaria.getTipoDeConta()));
            }
        } else {
            return null;
        }
    }
}
