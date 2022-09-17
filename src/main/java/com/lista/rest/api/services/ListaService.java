package com.lista.rest.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lista.rest.api.entities.ListaEntity;
import com.lista.rest.api.repositories.ListaRepository;

@Component
public class ListaService {
	
	@Autowired
	private ListaRepository listaRepository;

	public ListaEntity cadastra(ListaEntity lista) {
		return listaRepository.save(lista);
	}

	public List<ListaEntity> listaTodas() {
		return listaRepository.findAll();
	}

}
