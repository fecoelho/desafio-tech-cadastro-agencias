package com.fecoelho.desafio_tech_cadastro_agencias.service;

import com.fecoelho.desafio_tech_cadastro_agencias.model.entity.AgenciaEntity;
import com.fecoelho.desafio_tech_cadastro_agencias.model.request.CadastrarRequest;
import com.fecoelho.desafio_tech_cadastro_agencias.repository.AgenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgenciaService {

    @Autowired
    AgenciaRepository agenciaRepository;

    public AgenciaEntity cadastraAgencia(CadastrarRequest cadastrarRequest) {
        AgenciaEntity agenciaEntity = cadastrarRequestToAgenciaEntity(cadastrarRequest);

        agenciaRepository.save(agenciaEntity);
        return agenciaEntity;

    }

    private AgenciaEntity cadastrarRequestToAgenciaEntity(CadastrarRequest cadastrarRequest) {
        if (cadastrarRequest.nomeAgencia() == null)
            return new AgenciaEntity(
                    "AGENCIA_" + (agenciaRepository.getMaxTransactionId() + 1),
                    cadastrarRequest.posX(),
                    cadastrarRequest.posY()
            );
        return new AgenciaEntity(
                cadastrarRequest.nomeAgencia(),
                cadastrarRequest.posX(),
                cadastrarRequest.posY()
        );
    }
}
