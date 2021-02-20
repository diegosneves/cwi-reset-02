package com.company.domain;

import com.company.exceptions.EditoraNomeException;

public class Editora {

    private static final String NOME_INVALIDO = "DC Comics";
    private String nome, localizacao;

    public Editora(String nome, String localizacao) {
        if (NOME_INVALIDO.equals(nome)){
            throw new EditoraNomeException();
        }
        this.nome = nome;
        this.localizacao = localizacao;
    }

    @Override
    public String toString() {
        return "\nEditora{" +
                "nome='" + nome + '\'' +
                ", localizacao='" + localizacao + '\'' +
                '}';
    }
}
