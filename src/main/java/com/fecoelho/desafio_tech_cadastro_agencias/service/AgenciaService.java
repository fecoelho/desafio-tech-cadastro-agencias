package com.fecoelho.desafio_tech_cadastro_agencias.service;

import com.fecoelho.desafio_tech_cadastro_agencias.exception.ZoneNotFoundException;
import com.fecoelho.desafio_tech_cadastro_agencias.model.entity.AgenciaEntity;
import com.fecoelho.desafio_tech_cadastro_agencias.model.request.CadastrarRequest;
import com.fecoelho.desafio_tech_cadastro_agencias.model.response.DistanciaResponse;
import com.fecoelho.desafio_tech_cadastro_agencias.repository.AgenciaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AgenciaService {

    @Autowired
    AgenciaRepository agenciaRepository;

    private static final Logger logger = LoggerFactory.getLogger(AgenciaService.class);

    public AgenciaEntity cadastraAgencia(CadastrarRequest cadastrarRequest) {
        AgenciaEntity agenciaEntity = cadastrarRequestToAgenciaEntity(cadastrarRequest);
        logger.info("Salvando agencia no banco de dados.");
        agenciaRepository.save(agenciaEntity);
        logger.info("Agencia salva com sucesso.");
        return agenciaEntity;
    }

    public List<DistanciaResponse> getDistancia(Double posX, Double posY, Integer zona) {
        logger.info("Recuperando todas as agencias no zona {}.", zona);
        Optional<List<AgenciaEntity>> optionalAgenciaEntities = agenciaRepository.findByIdZona(zona);
        if (optionalAgenciaEntities.isEmpty() || optionalAgenciaEntities.get().isEmpty()) {
            logger.info("Nao ha nenhuma agencia nessa regiao");
            throw new ZoneNotFoundException("Não há nenhuma agencia nessa região. :(");
        }

        List<AgenciaEntity> agenciaEntities = optionalAgenciaEntities.get();
        List<DistanciaResponse> distanciaResponseList = new ArrayList<>();
        logger.info("Agencias recuperadas: {}", agenciaEntities.size());
        logger.info("Calculando distancia entre localizacao e agencias.");
        for (AgenciaEntity agenciaEntity : agenciaEntities) {
            distanciaResponseList.add(new DistanciaResponse(
                    agenciaEntity.getNomeAgencia(),
                    calculateDistance(
                            agenciaEntity.getLat(),
                            agenciaEntity.getLng(),
                            posY,
                            posX)));
        }
        logger.info("Calculo realizado com sucesso");
        return distanciaResponseList;
    }

    private AgenciaEntity cadastrarRequestToAgenciaEntity(CadastrarRequest cadastrarRequest) {
        if (cadastrarRequest.nomeAgencia() == null) {
            logger.info("Cadastrando agencia com nome generico");
            return new AgenciaEntity(
                    "AGENCIA_" + (agenciaRepository.getMaxTransactionId() + 1),
                    cadastrarRequest.posX(),
                    cadastrarRequest.posY(),
                    cadastrarRequest.idZona()
            );
        }
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
