package com.fecoelho.desafio_tech_cadastro_agencias.exception;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ErrorResponseTest {
    @Test
    void testNoArgsConstructor() {
        ErrorResponse error = new ErrorResponse();
        assertNull(error.getMessage());
        assertEquals(0, error.getStatusCode());
    }

    @Test
    void testMessageConstructor() {
        ErrorResponse error = new ErrorResponse("Error message");
        assertEquals("Error message", error.getMessage());
    }

    @Test
    void testAllArgsConstructor() {
        ErrorResponse error = new ErrorResponse(404, "Not found");
        assertEquals(404, error.getStatusCode());
        assertEquals("Not found", error.getMessage());
    }

    @Test
    void testSettersAndGetters() {
        ErrorResponse error = new ErrorResponse();
        error.setStatusCode(500);
        error.setMessage("Internal error");
        assertEquals(500, error.getStatusCode());
        assertEquals("Internal error", error.getMessage());
    }
}
