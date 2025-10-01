package com.fecoelho.desafio_tech_cadastro_agencias.exception;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ZoneNotFoundExceptionTest {
    @Test
    void testNoArgsConstructor() {
        ZoneNotFoundException ex = new ZoneNotFoundException();
        assertNull(ex.getMessage());
    }

    @Test
    void testMessageConstructor() {
        ZoneNotFoundException ex = new ZoneNotFoundException("Zone not found");
        assertEquals("Zone not found", ex.getMessage());
    }
}
