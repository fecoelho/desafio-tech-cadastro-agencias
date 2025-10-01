package com.fecoelho.desafio_tech_cadastro_agencias.model.entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ZonaEntityTest {
    @Test
    void testNoArgsConstructor() {
        ZonaEntity entity = new ZonaEntity();
        assertNull(entity.getIdZona());
        assertNull(entity.getNomeZona());
    }

    @Test
    void testAllArgsConstructorAndGetters() {
        ZonaEntity entity = new ZonaEntity("Zona Norte");
        assertNull(entity.getIdZona()); // id is generated
        assertEquals("Zona Norte", entity.getNomeZona());
    }
}
