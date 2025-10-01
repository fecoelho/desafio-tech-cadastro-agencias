package com.fecoelho.desafio_tech_cadastro_agencias.repository;

import com.fecoelho.desafio_tech_cadastro_agencias.model.entity.AgenciaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AgenciaRepository extends JpaRepository<AgenciaEntity, Integer> {

    @Query(value = "SELECT COALESCE(MAX(idAgencia), 0) FROM AgenciaEntity")
    int getMaxTransactionId();

    Optional<List<AgenciaEntity>> findByIdZona(Integer idZona);
}
