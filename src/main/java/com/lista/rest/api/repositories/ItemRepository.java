package com.lista.rest.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lista.rest.api.entities.ItemEntity;

@Repository
public interface ItemRepository extends JpaRepository<ItemEntity, Long> {

	List<ItemEntity> findAllByListaId (Long idLista);
}
