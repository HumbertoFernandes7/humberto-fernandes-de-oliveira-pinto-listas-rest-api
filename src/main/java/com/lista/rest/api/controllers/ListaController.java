package com.lista.rest.api.controllers;

import java.util.List;

import javax.validation.Valid;

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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Lista")
@RestController
@RequestMapping(ControllerConfig.URL_API + "/lista")
@CrossOrigin(origins = "*")
public class ListaController {

	@Autowired
	private ListaConvert listaConvert;

	@Autowired
	private ListaService listaService;
	

	@Operation(summary = "Cadastra Lista", description = "Cadastra uma Lista no banco de dados")
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public ListaOutput cadastraLista(
			@Parameter(description = "Representação da Lista") @RequestBody @Valid ListaInput listaInput) {
		ListaEntity lista = listaConvert.inputToEntity(listaInput);
		ListaEntity listaCriada = listaService.cadastra(lista);
		return listaConvert.entityToOutput(listaCriada);
	}
	

	@Operation(summary = "Altera Lista", description = "Altera uma Lista no banco de dados pelo seu Id")
	@PutMapping("/{id}")
	public ListaOutput alteraLista(@Parameter(description = "Id da Lista", example = "1") @PathVariable Long id,
			@Parameter(description = "Representação da Lista") @RequestBody @Valid ListaInput listaInput) {
		ListaEntity lista = listaConvert.inputToEntity(listaInput);
		lista.setId(id);
		ListaEntity listaAlterada = listaService.alteraLista(lista);
		return listaConvert.entityToOutput(listaAlterada);
	}
	

	@Operation(summary = "Busca todas as Listas", description = "Lista todas as Listas cadastradas no banco de dados ")
	@GetMapping
	public List<ListaOutput> listaTodasListas() {
		List<ListaEntity> listaTodas = listaService.listaTodas();
		return listaConvert.entityToOutput(listaTodas);
	}
	

	@Operation(summary = "Busca Lista", description = "Busca uma Lista no banco de dados pelo seu Id")
	@GetMapping("/{id}")
	public ListaOutput listaPeloIdDaLista(
			@Parameter(description = "Id da Lista", example = "1") @PathVariable Long id) {
		ListaEntity listaEncontrada = listaService.buscaListaPorId(id);
		return listaConvert.entityToOutput(listaEncontrada);
	}
	

	@Operation(summary = "Deleta Lista", description = "Deleta uma Lista no banco de dados pelo seu Id")
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deletaLista(@Parameter(description = "Id da Lista", example = "1") @PathVariable Long id) {
		ListaEntity listaEncontrada = listaService.buscaListaPorId(id);
		listaService.deletaLista(listaEncontrada);
	}
}
