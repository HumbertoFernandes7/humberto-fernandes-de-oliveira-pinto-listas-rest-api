package com.lista.rest.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lista.rest.api.entities.ListaEntity;

@Repository
public interface ListaRepository extends JpaRepository<ListaEntity, Long> {

}
