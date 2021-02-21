package com.company.exceptions;

public class DefineAvaliacaoException extends IllegalArgumentException {
    public DefineAvaliacaoException() {
        super("\n\nValor inválido!!!\nRevise o valor atribuido no construtor\n\n");
    }
}
