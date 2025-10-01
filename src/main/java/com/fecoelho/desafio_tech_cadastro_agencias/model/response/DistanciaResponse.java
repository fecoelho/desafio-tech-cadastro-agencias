package com.fecoelho.desafio_tech_cadastro_agencias.model.response;

public record DistanciaResponse(
        String nomeAgencia,
        Double distancia
) { //Mudei o response por ele não ser um json valido
}
