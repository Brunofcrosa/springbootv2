package br.ufsm.salas.infra;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EntidadeNaoEncontradaException extends RuntimeException {
    public EntidadeNaoEncontradaException(final String mensagem) {
        super(mensagem);
    }
}
