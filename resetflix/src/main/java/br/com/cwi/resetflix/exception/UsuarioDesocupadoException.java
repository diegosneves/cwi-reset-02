package br.com.cwi.resetflix.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NO_CONTENT)
public class UsuarioDesocupadoException extends RuntimeException {
    public UsuarioDesocupadoException(String message) {
        super(message);
    }
}
