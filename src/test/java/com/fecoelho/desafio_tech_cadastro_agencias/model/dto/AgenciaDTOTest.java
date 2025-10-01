package com.fecoelho.desafio_tech_cadastro_agencias.model.dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AgenciaDTOTest {
    @Test
    void testRecordFields() {
        AgenciaDTO dto = new AgenciaDTO(1, "Agencia X", 10.5, 20.5);
        assertEquals(1, dto.idAgencia());
        assertEquals("Agencia X", dto.nomeAgencia());
        assertEquals(10.5, dto.lng());
        assertEquals(20.5, dto.lat());
    }
}
