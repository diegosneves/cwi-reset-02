package br.com.cwi.resetflix.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpStatusCodeException;

@ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
public class UsuarioDesocupadoException extends HttpStatusCodeException {

    private static final long serialVersionUID = -4560532949002428309L;

    static HttpStatus status = HttpStatus.I_AM_A_TEAPOT;

    public UsuarioDesocupadoException(final String statusText) {
        super(status, statusText);
    }
}
