package com.lista.rest.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.lista.rest.api.configs.ControllerConfig;
import com.lista.rest.api.converts.ItemConvert;
import com.lista.rest.api.dto.inputs.ItemInput;
import com.lista.rest.api.dto.outputs.ItemOutput;
import com.lista.rest.api.entities.ItemEntity;
import com.lista.rest.api.services.ItemService;

@RestController
@RequestMapping(ControllerConfig.URL_API + "/item")
@CrossOrigin(origins = "*")
public class ItemController {

	@Autowired
	private ItemConvert itemConvert;

	@Autowired
	private ItemService itemService;

	// Cadastra Item
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public ItemOutput cadastraItem(@RequestBody @Valid ItemInput itemInput) {
		ItemEntity item = itemConvert.inputToEntity(itemInput);
		// item.setConcluido(false);
		ItemEntity itemCriada = itemService.cadastra(item);
		return itemConvert.entityToOutput(itemCriada);
	}

	// Altera Item
	@PutMapping("/{id}")
	public ItemOutput alteraItem(@PathVariable Long id, @RequestBody @Valid ItemInput itemInput) {
		ItemEntity item = itemConvert.inputToEntity(itemInput);
		item.setId(id);
		ItemEntity itemAlterado = itemService.alteraItem(item);
		return itemConvert.entityToOutput(itemAlterado);
	}

	// Deleta Item por Id
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deletaItem(@PathVariable Long id) {
		ItemEntity listaEncontrada = itemService.buscaItemPorId(id);
		itemService.deletaItem(listaEncontrada);
	}
}
