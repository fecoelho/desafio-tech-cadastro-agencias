package com.fecoelho.desafio_tech_cadastro_agencias.exception;

import org.junit.jupiter.api.Test;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.*;

class GlobalExceptionHandlerTest {
    private final GlobalExceptionHandler handler = new GlobalExceptionHandler();

    @Test
    void testHandleZoneNotFoundException() {
        ZoneNotFoundException ex = new ZoneNotFoundException("Zone not found");
        ErrorResponse response = handler.handleException(ex);
        assertEquals(HttpStatus.NOT_FOUND.value(), response.getStatusCode());
        assertEquals("Zone not found", response.getMessage());
    }

    @Test
    void testHandleDataIntegrityViolationException() {
        DataIntegrityViolationException ex = new DataIntegrityViolationException("Integrity error");
        ErrorResponse response = handler.handleException(ex);
        assertEquals(HttpStatus.BAD_REQUEST.value(), response.getStatusCode());
        assertEquals("Integrity error", response.getMessage());
    }
}
