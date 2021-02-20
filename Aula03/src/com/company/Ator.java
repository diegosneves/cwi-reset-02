package com.company;

public class Ator extends Pessoa {
    private int quantidadeOscarsVencidos;

    public Ator(String nome, int idade, int quantidadeOscarsVencidos, Genero genero) {
        super(nome, idade, genero);
        this.quantidadeOscarsVencidos = quantidadeOscarsVencidos;
    }

}
