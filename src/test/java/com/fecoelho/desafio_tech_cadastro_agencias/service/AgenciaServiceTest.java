package com.fecoelho.desafio_tech_cadastro_agencias.service;

import com.fecoelho.desafio_tech_cadastro_agencias.exception.ZoneNotFoundException;
import com.fecoelho.desafio_tech_cadastro_agencias.model.entity.AgenciaEntity;
import com.fecoelho.desafio_tech_cadastro_agencias.model.request.CadastrarRequest;
import com.fecoelho.desafio_tech_cadastro_agencias.model.response.DistanciaResponse;
import com.fecoelho.desafio_tech_cadastro_agencias.repository.AgenciaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AgenciaServiceTest {
    @Mock
    private AgenciaRepository agenciaRepository;

    @InjectMocks
    private AgenciaService agenciaService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCadastraAgenciaWithNome() {
        CadastrarRequest req = new CadastrarRequest("Agencia Teste", 1.0, 2.0, 3);
        AgenciaEntity entity = new AgenciaEntity("Agencia Teste", 1.0, 2.0, 3);
        when(agenciaRepository.save(any(AgenciaEntity.class))).thenReturn(entity);
        AgenciaEntity result = agenciaService.cadastraAgencia(req);
        assertEquals("Agencia Teste", result.getNomeAgencia());
        assertEquals(1.0, result.getLng());
        assertEquals(2.0, result.getLat());
        assertEquals(3, result.getIdZona());
        verify(agenciaRepository, times(1)).save(any(AgenciaEntity.class));
    }

    @Test
    void testCadastraAgenciaWithNullNome() {
        AgenciaEntity savedEntity = new AgenciaEntity("AGENCIA_11", 1.0, 2.0, 3);
        CadastrarRequest req = new CadastrarRequest(null, 1.0, 2.0, 3);
        when(agenciaRepository.getMaxTransactionId()).thenReturn(10);
        when(agenciaRepository.save(any(AgenciaEntity.class))).thenReturn(savedEntity);
        AgenciaEntity result = agenciaService.cadastraAgencia(req);
        assertTrue(result.getNomeAgencia().startsWith("AGENCIA_"));
        assertEquals(1.0, result.getLng());
        assertEquals(2.0, result.getLat());
        assertEquals(3, result.getIdZona());
        verify(agenciaRepository, times(1)).save(any(AgenciaEntity.class));
    }

    @Test
    void testGetDistanciaSuccess() {
        AgenciaEntity entity = new AgenciaEntity("Agencia A", 10.0, 20.0, 1);
        List<AgenciaEntity> entities = Arrays.asList(entity);
        when(agenciaRepository.findByIdZona(1)).thenReturn(Optional.of(entities));
        List<DistanciaResponse> result = agenciaService.getDistancia(20.0, 10.0, 1);
        assertEquals(1, result.size());
        assertEquals("Agencia A", result.get(0).nomeAgencia());
        assertNotNull(result.get(0).distancia());
        verify(agenciaRepository, times(1)).findByIdZona(1);
    }

    @Test
    void testGetDistanciaZoneNotFound() {
        when(agenciaRepository.findByIdZona(99)).thenReturn(Optional.empty());
        assertThrows(ZoneNotFoundException.class, () -> agenciaService.getDistancia(1.0, 2.0, 99));
        verify(agenciaRepository, times(1)).findByIdZona(99);
    }

    @Test
    void testGetDistanciaZoneEmptyList() {
        when(agenciaRepository.findByIdZona(100)).thenReturn(Optional.of(Collections.emptyList()));
        assertThrows(ZoneNotFoundException.class, () -> agenciaService.getDistancia(1.0, 2.0, 100));
        verify(agenciaRepository, times(1)).findByIdZona(100);
    }
}
