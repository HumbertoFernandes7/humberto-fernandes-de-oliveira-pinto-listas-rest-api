package com.lista.rest.api.converts;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lista.rest.api.dto.inputs.AlteraConcluidoItemInput;
import com.lista.rest.api.dto.inputs.AlteraItemInput;
import com.lista.rest.api.dto.inputs.ItemInput;
import com.lista.rest.api.dto.outputs.ItemOutput;
import com.lista.rest.api.entities.ItemEntity;

@Component
public class ItemConvert {

	@Autowired
	private ModelMapper modelMapper;
	
	public ItemEntity inputToNewEntity(ItemInput itemInput) {
		return modelMapper.map(itemInput, ItemEntity.class);
	}
	
	public ItemEntity inputToEntity(ItemEntity entity, AlteraItemInput Input) {
		modelMapper.map(Input, entity);
		return entity;
	}

	public ItemOutput entityToOutput(ItemEntity itemCriado) {
		return modelMapper.map(itemCriado, ItemOutput.class);
	}

	public List<ItemOutput> entityToOutput(List<ItemEntity> itemEntity) {
		return itemEntity.stream().map(a -> this.entityToOutput(a)).collect(Collectors.toList());
	}

	public ItemEntity inputAlteraConcluidoToEntity(@Valid AlteraConcluidoItemInput input) {
		return modelMapper.map(input, ItemEntity.class);
	}

	
}
