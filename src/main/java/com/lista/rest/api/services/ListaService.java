package com.lista.rest.api.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lista.rest.api.entities.ListaEntity;
import com.lista.rest.api.repositories.ListaRepository;

@Service
public class ListaService {
	
	@Autowired
	private ListaRepository listaRepository;

	@Transactional
	public ListaEntity cadastra(ListaEntity lista) {
		return listaRepository.save(lista);
	}

	public List<ListaEntity> listaTodas() {
		return listaRepository.findAll();
	}

	public ListaEntity buscaListaPorId(Long id) {
		return listaRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Não foi encontrado o Id " + id));
	}

	@Transactional
	public void deletaLista(ListaEntity listaEncontrada) {
		listaRepository.delete(listaEncontrada);
	}

	@Transactional
	public ListaEntity alteraLista(ListaEntity lista) {
		return listaRepository.save(lista);
	}

}
