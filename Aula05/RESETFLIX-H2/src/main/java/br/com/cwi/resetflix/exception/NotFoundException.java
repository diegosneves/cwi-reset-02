package br.com.cwi.resetflix.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpStatusCodeException;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends HttpStatusCodeException {

    private static final long serialVersionUID = -4560532949002428309L;

    static HttpStatus status = HttpStatus.NOT_FOUND;

    public NotFoundException(final String statusText) {
        super(status, statusText);
    }
}
