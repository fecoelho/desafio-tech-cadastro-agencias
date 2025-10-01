package com.fecoelho.desafio_tech_cadastro_agencias.model.request;

import jakarta.validation.constraints.NotNull;

public record CadastrarRequest(
        String nomeAgencia,
        @NotNull(message = "Longitude não pode ser nula.")
        Double posX,
        @NotNull(message = "Latitude não pode ser nula.")
        Double posY,
        @NotNull(message = "Zona não pode ser nula.")
        Integer idZona
) {
}
