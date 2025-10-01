package com.fecoelho.desafio_tech_cadastro_agencias.controller;

import com.fecoelho.desafio_tech_cadastro_agencias.model.entity.AgenciaEntity;
import com.fecoelho.desafio_tech_cadastro_agencias.model.request.CadastrarRequest;
import com.fecoelho.desafio_tech_cadastro_agencias.service.AgenciaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/desafio")
public class AgenciasController {

    @Autowired
    AgenciaService agenciaService;

    @GetMapping(value = "/distancia")
    ResponseEntity<?> getDistancia() {
        return null;
    }

    @PostMapping("/cadastrar")
    ResponseEntity<AgenciaEntity> createAgencia(
            @RequestBody @Valid CadastrarRequest cadastrarRequest
    ) {
        return new ResponseEntity<>(agenciaService.cadastraAgencia(cadastrarRequest), HttpStatus.CREATED);
    }
}


