package com.lista.rest.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.lista.rest.api.dto.inputs.AlteraItemInput;
import com.lista.rest.api.dto.inputs.ItemInput;
import com.lista.rest.api.dto.outputs.ItemOutput;
import com.lista.rest.api.entities.ItemEntity;
import com.lista.rest.api.services.ItemService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Item")
@RestController
@RequestMapping(ControllerConfig.URL_API + "/item")
@CrossOrigin(origins = "*")
public class ItemController {

	@Autowired
	private ItemConvert itemConvert;

	@Autowired
	private ItemService itemService;

	// @Autowired
	// private ListaService listaService;

	
	@Operation(summary = "Cadastra Item", description = "Cadastra um Item no banco de dados")
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public ItemOutput cadastraItem(
			@Parameter(description = "Representação do Item") @RequestBody @Valid ItemInput itemInput) {
		ItemEntity item = itemConvert.inputToNewEntity(itemInput);
		item.setConcluido(false);

		// convertLista(itemInput, item);

		ItemEntity itemCriado = itemService.cadastra(item);
		return itemConvert.entityToOutput(itemCriado);
	}
	

	@Operation(summary = "Altera Item", description = "Altera um Item no banco de dados")
	@PutMapping("/{id}")
	public ResponseEntity<?> alteraItem(@Parameter(description = "Id do Item", example = "1") @PathVariable Long id,
			@Parameter(description = "Representação do Item") @RequestBody @Valid AlteraItemInput itemInput) {
		ItemEntity itemEncontrado = itemService.buscaItemPorId(id);
		ItemEntity itemConvertido = itemConvert.inputToEntity(itemEncontrado, itemInput);
		itemService.alteraItem(itemConvertido, itemInput);
		return ResponseEntity.ok().build();
	}
	

	@Operation(summary = "Deleta Item", description = "Deleta um Item no banco de dados")
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deletaItem(@Parameter(description = "Id do Item", example = "1") @PathVariable Long id) {
		ItemEntity itemEncontrado = itemService.buscaItemPorId(id);
		itemService.deletaItem(itemEncontrado);
	}
	

	@Operation(summary = "Marca Item como concluido", description = "Altera um Item para concluido")
	@PutMapping("/{id}/concluido")
	public ItemOutput marcaItemParaConcluido(
			@Parameter(description = "Id do Item", example = "1") @PathVariable Long id) {
		// ItemEntity item = itemConvert.inputAlteraConcluidoToEntity(input);
		ItemEntity item = itemService.buscaItemPorId(id);
		item.setId(id);
		item.setConcluido(true);
		ItemEntity itemAlterado = itemService.alteraItemConcluido(item);
		return itemConvert.entityToOutput(itemAlterado);
	}
	

	@Operation(summary = "Desmarca Item como concluido", description = "Altera um Item para não concluido")
	@PutMapping("/{id}/nao-concluido")
	public ItemOutput marcaItemParaNãoConcluido(
			@Parameter(description = "Id do Item", example = "1") @PathVariable Long id) {
		ItemEntity item = itemService.buscaItemPorId(id);
		item.setId(id);
		item.setConcluido(false);
		ItemEntity itemAlterado = itemService.alteraItemConcluido(item);
		return itemConvert.entityToOutput(itemAlterado);
	}
}




//	private void convertLista(ItemInput input, ItemEntity entity) {
//		List<ListaEntity> lista = new ArrayList<>();
//	
//		for(Long listaId : input.getListaId()) {
//			lista.add(listaService.buscaListaPorId(listaId));
//		}
//		entity.setLista(lista);
//	}