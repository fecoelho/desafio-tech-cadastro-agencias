package com.fecoelho.desafio_tech_cadastro_agencias.controller;

import com.fecoelho.desafio_tech_cadastro_agencias.model.dto.AgenciaDTO;
import com.fecoelho.desafio_tech_cadastro_agencias.model.entity.AgenciaEntity;
import com.fecoelho.desafio_tech_cadastro_agencias.model.request.CadastrarRequest;
import com.fecoelho.desafio_tech_cadastro_agencias.model.response.DistanciaResponse;
import com.fecoelho.desafio_tech_cadastro_agencias.service.AgenciaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/desafio")
public class AgenciasController {

    @Autowired
    AgenciaService agenciaService;

    @GetMapping(value = "/distancia")
    ResponseEntity<List<DistanciaResponse>> getDistancia(
            @RequestParam Double posX,
            @RequestParam Double posY,
            @RequestParam Integer zona
    ) {
        return new ResponseEntity<>(agenciaService.getDistancia(posX, posY, zona), HttpStatus.OK);
    }

    @PostMapping("/cadastrar")
    ResponseEntity<AgenciaEntity> createAgencia(
            @RequestBody @Valid CadastrarRequest cadastrarRequest
    ) {
        return new ResponseEntity<>(agenciaService.cadastraAgencia(cadastrarRequest), HttpStatus.CREATED);
    }
}
