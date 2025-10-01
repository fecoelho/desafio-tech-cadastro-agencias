package com.fecoelho.desafio_tech_cadastro_agencias.exception;

public class ZoneNotFoundException extends RuntimeException {
    public ZoneNotFoundException() {
    }

    public ZoneNotFoundException(String message) {
        super(message);
    }
}
