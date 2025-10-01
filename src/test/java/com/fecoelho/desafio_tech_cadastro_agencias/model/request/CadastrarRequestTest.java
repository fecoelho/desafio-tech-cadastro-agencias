package com.fecoelho.desafio_tech_cadastro_agencias.model.request;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CadastrarRequestTest {
    @Test
    void testRecordFields() {
        CadastrarRequest req = new CadastrarRequest("Agencia Z", 12.0, 23.0, 3);
        assertEquals("Agencia Z", req.nomeAgencia());
        assertEquals(12.0, req.posX());
        assertEquals(23.0, req.posY());
        assertEquals(3, req.idZona());
    }
}
