package com.lista.rest.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.lista.rest.api.configs.ControllerConfig;
import com.lista.rest.api.converts.ListaConvert;
import com.lista.rest.api.dto.inputs.ListaInput;
import com.lista.rest.api.dto.outputs.ListaOutput;
import com.lista.rest.api.entities.ListaEntity;
import com.lista.rest.api.services.ListaService;

@RestController
@RequestMapping(ControllerConfig.URL_API + "/lista")
@CrossOrigin(origins = "*")
public class ListaController {

	
	@Autowired
	private ListaConvert listaConvert;
	
	@Autowired
	private ListaService listaService;

	//Cadastra Lista
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public ListaOutput cadastraLista(@RequestBody ListaInput listaInput ) {
		ListaEntity lista = listaConvert.inputToEntity(listaInput);
		ListaEntity listaCriada = listaService.cadastra(lista);
		return listaConvert.entityToOutput(listaCriada);
	}
	
	@PutMapping("/{id}")
	public ListaOutput alteraLista(@PathVariable Long id, @RequestBody ListaInput listaInput) {
		ListaEntity lista = listaConvert.inputToEntity(listaInput);
		lista.setId(id);
		ListaEntity listaAlterada = listaService.alteraLista(lista);
		return listaConvert.entityToOutput(listaAlterada);
	}
	
	//Lista todas as Listas
	@GetMapping
	public List<ListaOutput> listaTodasListas() {
		List<ListaEntity> listaTodas = listaService.listaTodas();
		return listaConvert.entityToOutput(listaTodas);
	}
	
	//Busca lista por Id
	@GetMapping("/{id}")
	public ListaOutput listaPeloIdDaLista(@PathVariable Long id) {
		ListaEntity listaEncontrada = listaService.buscaListaPorId(id);
		return listaConvert.entityToOutput(listaEncontrada);
	}
	
	//Deleta lista por Id
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deletaLista(@PathVariable Long id) {
		ListaEntity listaEncontrada = listaService.buscaListaPorId(id);
		listaService.deletaLista(listaEncontrada);
	}

}
