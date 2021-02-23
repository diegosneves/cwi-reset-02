package br.com.banco.desgraca.domain;

import br.com.banco.desgraca.exception.InstituicaoBancariaInvalidaException;

public class ValidaBanco {

    public static InstituicaoBancaria validarAberturaDeConta(InstituicaoBancaria banco, TaxasTransacoes tipoDeConta){
        if (tipoDeConta == TaxasTransacoes.CD){
            if(banco.getAceitaContaDigital()){
                return banco;
            } else {
                throw new InstituicaoBancariaInvalidaException(String.format("\nInfelizmente o banco %s não tem Suporte para uma %s!!\n",
                        banco.getNome(),
                        tipoDeConta.getTipoDeConta()));
            }
        } else if (tipoDeConta == TaxasTransacoes.CP) {
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
