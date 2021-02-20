package com.debug;

public class Imc {

    private Double altura;
    private Integer peso;

    public Imc(final Double altura, final Integer peso) {
        this.altura = altura;
        this.peso = peso;
    }

    public Double calculo() {
        return peso / (altura * altura);
    }
}
