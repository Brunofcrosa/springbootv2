package br.ufsm.salas.infra;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class RegraNegocioException extends RuntimeException {
    public RegraNegocioException(final String mensagem) {
        super(mensagem);
    }
}
