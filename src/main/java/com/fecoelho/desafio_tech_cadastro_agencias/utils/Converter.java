package com.fecoelho.desafio_tech_cadastro_agencias.utils;


import com.fecoelho.desafio_tech_cadastro_agencias.model.dto.AgenciaDTO;
import com.fecoelho.desafio_tech_cadastro_agencias.model.entity.AgenciaEntity;

public class Converter {

    public static AgenciaDTO agenciaEntityToDTO(AgenciaEntity agencia) {
        return new AgenciaDTO(
                agencia.getIdAgencia(),
                agencia.getNomeAgencia(),
                agencia.getLng(),
                agencia.getLat());
    }
}
