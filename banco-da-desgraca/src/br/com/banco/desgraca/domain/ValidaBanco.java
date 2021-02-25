package br.com.banco.desgraca.domain;

import br.com.banco.desgraca.exception.InstituicaoBancariaInvalidaException;

/**
 * Classe ValidaBanco - Verifica conforme as regras de negócio se a Instituição Financeira presta suporte ao tipo de conta:
 * Conta Corrente;
 * Conta Digital;
 * Conta Poupança;
 */
public class ValidaBanco {

    private static final TaxasTransacoes CONTA_POUPANCA = TaxasTransacoes.CP;
    private static final TaxasTransacoes CONTA_DIGITAL = TaxasTransacoes.CD;

    /**
     * Método Static usado para verificar se o banco(Instituição Bancaria) presta suporte para o tipo de conta passado
     * como parametro(Conta Corrente, Conta Digital ou Conta Poupança).
     *
     * @param banco Instituição Bancaria no qual deseja abrir a conta.
     * @param tipoDeConta Tipo de conta(Conta Corrente, Conta Digital ou Conta Poupança) que deseja criar.
     * @return Retorna o banco(Instituição Bancaria) caso as condições sejam satisfeitas conforme as regras de negócio.
     */
    public static InstituicaoBancaria validarAberturaDeConta(InstituicaoBancaria banco, TaxasTransacoes tipoDeConta){
        if (tipoDeConta.equals(CONTA_DIGITAL)){
            if(banco.getAceitaContaDigital()){
                return banco;
            } else {
                throw new InstituicaoBancariaInvalidaException(String.format("\nInfelizmente o banco %s não tem Suporte para uma %s!!\n",
                        banco.getNome(),
                        tipoDeConta.getTipoDeConta()));
            }
        } else if (tipoDeConta.equals(CONTA_POUPANCA)) {
            if(banco.getAceitaContaPoupanca()){
                return banco;
            } else {
                throw new InstituicaoBancariaInvalidaException(String.format("\nInfelizmente o banco %s não tem Suporte para uma %s!!\n",
                        banco.getNome(),
                        tipoDeConta.getTipoDeConta()));
            }
        } else {
            return null;
        }
    }
}
