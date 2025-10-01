package com.fecoelho.desafio_tech_cadastro_agencias.model.dto;

public record AgenciaDTO(
        Integer idAgencia,
        String nomeAgencia,
        Double lng, // x
        Double lat // y
) {
}
