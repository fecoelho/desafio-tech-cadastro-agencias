package com.fecoelho.desafio_tech_cadastro_agencias.model.response;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DistanciaResponseTest {
    @Test
    void testRecordFields() {
        DistanciaResponse resp = new DistanciaResponse("Agencia W", 5.5);
        assertEquals("Agencia W", resp.nomeAgencia());
        assertEquals(5.5, resp.distancia());
    }
}
