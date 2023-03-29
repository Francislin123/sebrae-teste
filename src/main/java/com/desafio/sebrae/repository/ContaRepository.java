package com.desafio.sebrae.repository;

import com.desafio.sebrae.repository.conta.ContaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContaRepository extends JpaRepository<ContaEntity, Long> {

    ContaEntity findByNome(final String nome);

    Optional<ContaEntity> findById(final Long nome);

}
