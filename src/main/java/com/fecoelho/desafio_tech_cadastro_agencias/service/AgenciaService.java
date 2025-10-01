package com.fecoelho.desafio_tech_cadastro_agencias.service;

import com.fecoelho.desafio_tech_cadastro_agencias.model.entity.AgenciaEntity;
import com.fecoelho.desafio_tech_cadastro_agencias.model.request.CadastrarRequest;
import com.fecoelho.desafio_tech_cadastro_agencias.model.response.DistanciaResponse;
import com.fecoelho.desafio_tech_cadastro_agencias.repository.AgenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AgenciaService {

    @Autowired
    AgenciaRepository agenciaRepository;

    public AgenciaEntity cadastraAgencia(CadastrarRequest cadastrarRequest) {
        AgenciaEntity agenciaEntity = cadastrarRequestToAgenciaEntity(cadastrarRequest);

        try {
            agenciaRepository.save(agenciaEntity);
        } catch (DataIntegrityViolationException e) {
            //todo tratar
        }
        return agenciaEntity;
    }

    public List<DistanciaResponse> getDistancia(Double posX, Double posY, Integer zona) {
        Optional<List<AgenciaEntity>> optionalAgenciaEntities = agenciaRepository.findByIdZona(zona);
        if (optionalAgenciaEntities.isEmpty())
            //todo retorna excessao que nao tem nada nessa zona
            return null;

        List<AgenciaEntity> agenciaEntities = optionalAgenciaEntities.get();
        List<DistanciaResponse> distanciaResponseList = new ArrayList<>();
        for (AgenciaEntity agenciaEntity : agenciaEntities) {
            distanciaResponseList.add(new DistanciaResponse(
                    agenciaEntity.getNomeAgencia(),
                    calculateDistance(
                            agenciaEntity.getLat(),
                            agenciaEntity.getLng(),
                            posY,
                            posX)));
        }
        return distanciaResponseList;
    }

    private AgenciaEntity cadastrarRequestToAgenciaEntity(CadastrarRequest cadastrarRequest) {
        if (cadastrarRequest.nomeAgencia() == null)
            return new AgenciaEntity(
                    "AGENCIA_" + (agenciaRepository.getMaxTransactionId() + 1),
                    cadastrarRequest.posX(),
                    cadastrarRequest.posY(),
                    cadastrarRequest.idZona()
            );
        return new AgenciaEntity(
                cadastrarRequest.nomeAgencia(),
                cadastrarRequest.posX(),
                cadastrarRequest.posY(),
                cadastrarRequest.idZona()
        );
    }

    // Equirectangular Distance Approximation
    private double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        double lat1Rad = Math.toRadians(lat1);
        double lat2Rad = Math.toRadians(lat2);
        double lon1Rad = Math.toRadians(lon1);
        double lon2Rad = Math.toRadians(lon2);

        double x = (lon2Rad - lon1Rad) * Math.cos((lat1Rad + lat2Rad) / 2);
        double y = (lat2Rad - lat1Rad);
        return Math.sqrt(x * x + y * y) * 6371;
    }
}
