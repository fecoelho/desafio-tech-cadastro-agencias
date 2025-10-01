package com.fecoelho.desafio_tech_cadastro_agencias.repository;

import com.fecoelho.desafio_tech_cadastro_agencias.model.entity.AgenciaEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgenciaRepository extends CrudRepository<AgenciaEntity, Integer> {

    @Query(value = "SELECT COALESCE(MAX(idAgencia), 0) FROM AgenciaEntity")
    int getMaxTransactionId();
}
