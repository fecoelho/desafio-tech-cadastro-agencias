package com.fecoelho.desafio_tech_cadastro_agencias.model.entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AgenciaEntityTest {
    @Test
    void testNoArgsConstructor() {
        AgenciaEntity entity = new AgenciaEntity();
        assertNull(entity.getIdAgencia());
        assertNull(entity.getNomeAgencia());
        assertNull(entity.getLng());
        assertNull(entity.getLat());
        assertNull(entity.getIdZona());
    }

    @Test
    void testAllArgsConstructorAndGetters() {
        AgenciaEntity entity = new AgenciaEntity("Agencia Y", 11.0, 22.0, 2);
        assertNull(entity.getIdAgencia()); // id is generated
        assertEquals("Agencia Y", entity.getNomeAgencia());
        assertEquals(11.0, entity.getLng());
        assertEquals(22.0, entity.getLat());
        assertEquals(2, entity.getIdZona());
    }
}
