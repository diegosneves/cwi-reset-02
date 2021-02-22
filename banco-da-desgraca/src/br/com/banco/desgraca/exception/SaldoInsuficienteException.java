package br.com.banco.desgraca.exception;

public class SaldoInsuficienteException extends RuntimeException{
    public SaldoInsuficienteException(String mensagemDeErro) {
        super(mensagemDeErro);
    }
}
