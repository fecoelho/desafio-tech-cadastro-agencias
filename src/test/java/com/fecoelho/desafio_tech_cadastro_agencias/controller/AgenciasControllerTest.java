package com.fecoelho.desafio_tech_cadastro_agencias.controller;

import com.fecoelho.desafio_tech_cadastro_agencias.model.entity.AgenciaEntity;
import com.fecoelho.desafio_tech_cadastro_agencias.model.request.CadastrarRequest;
import com.fecoelho.desafio_tech_cadastro_agencias.model.response.DistanciaResponse;
import com.fecoelho.desafio_tech_cadastro_agencias.service.AgenciaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AgenciasControllerTest {

    @Mock
    private AgenciaService agenciaService;

    @InjectMocks
    private AgenciasController agenciasController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetDistancia() {
        Double posX = 1.0;
        Double posY = 2.0;
        Integer zona = 3;
        List<DistanciaResponse> mockResponse = Arrays.asList(
                new DistanciaResponse(
                        "teste1",
                        11.1
                ),
                new DistanciaResponse(
                        "teste2",
                        22.2));
        when(agenciaService.getDistancia(posX, posY, zona)).thenReturn(mockResponse);

        ResponseEntity<List<DistanciaResponse>> response = agenciasController.getDistancia(posX, posY, zona);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockResponse, response.getBody());
        verify(agenciaService, times(1)).getDistancia(posX, posY, zona);
    }

    @Test
    void testCreateAgencia() {
        CadastrarRequest request = new CadastrarRequest(
                "teste",
                11.1,
                22.2,
                1
        );
        AgenciaEntity mockEntity = new AgenciaEntity();
        when(agenciaService.cadastraAgencia(request)).thenReturn(mockEntity);

        ResponseEntity<AgenciaEntity> response = agenciasController.createAgencia(request);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(mockEntity, response.getBody());
        verify(agenciaService, times(1)).cadastraAgencia(request);
    }
}
