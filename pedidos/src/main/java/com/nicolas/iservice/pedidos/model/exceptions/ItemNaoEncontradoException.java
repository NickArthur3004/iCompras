package com.nicolas.iservice.pedidos.model.exceptions;

public class ItemNaoEncontradoException extends RuntimeException {
    public ItemNaoEncontradoException(String message) {
        super(message);
    }
}
