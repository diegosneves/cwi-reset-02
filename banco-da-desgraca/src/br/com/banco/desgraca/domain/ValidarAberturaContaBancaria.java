package br.com.banco.desgraca.domain;

import br.com.banco.desgraca.domain.conta.ContaBancaria;
import br.com.banco.desgraca.domain.conta.ContaDigital;
import br.com.banco.desgraca.domain.conta.ContaPoupanca;
import br.com.banco.desgraca.exception.InstituicaoBancariaInvalidaException;

/**
 * Classe ValidaBanco - Verifica conforme as regras de negócio se a Instituição Financeira presta suporte ao tipo de conta:
 * Conta Corrente;
 * Conta Digital;
 * Conta Poupança;
 */
public class ValidarAberturaContaBancaria {

    /**
     * Método Static usado para verificar se o banco(Instituição Bancaria) presta suporte para o tipo de conta
     * disponivel no projeto(Conta Corrente, Conta Digital ou Conta Poupança).
     *
     * @param contaBancaria Recebe um Objeto do tipo ContaBancaria
     */
    public static void validarSuporteTipoDeConta(ContaBancaria contaBancaria) {
        if (contaBancaria instanceof ContaDigital) {
            if (!contaBancaria.getInstituicaoBancaria().getAceitaContaDigital()) {
                throw new InstituicaoBancariaInvalidaException(String.format("\nInfelizmente o banco %s não tem Suporte para uma %s!!\n",
                        contaBancaria.getInstituicaoBancaria().getNome(),
                        DadosDaContaBancaria.CONTA_DIGITAL.getTipoDeConta()));
            }
        } else if (contaBancaria instanceof ContaPoupanca) {
            if (!contaBancaria.getInstituicaoBancaria().getAceitaContaPoupanca()) {
                throw new InstituicaoBancariaInvalidaException(String.format("\nInfelizmente o banco %s não tem Suporte para uma %s!!\n",
                        contaBancaria.getInstituicaoBancaria().getNome(),
                        DadosDaContaBancaria.CONTA_POUPANCA.getTipoDeConta()));
            }
        }
    }
}
