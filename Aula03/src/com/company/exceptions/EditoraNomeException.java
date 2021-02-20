package com.company.exceptions;

public class EditoraNomeException extends RuntimeException {

    public EditoraNomeException() {
        super("\n\nNome [DC Comics] é invalido!\nVerifique no construtor e insira um nome válido!\n\n");
    }
}
