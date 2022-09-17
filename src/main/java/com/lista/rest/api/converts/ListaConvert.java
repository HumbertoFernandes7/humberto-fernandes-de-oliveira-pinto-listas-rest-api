package com.lista.rest.api.converts;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lista.rest.api.dto.inputs.ListaInput;
import com.lista.rest.api.dto.outputs.ListaOutput;
import com.lista.rest.api.entities.ListaEntity;

@Component
public class ListaConvert {

	@Autowired
	private ModelMapper modelMapper;
	
	public ListaEntity inputToEntity(ListaInput listaInput) {
		return modelMapper.map(listaInput, ListaEntity.class);
	}

	public ListaOutput entityToOutput(ListaEntity listaCriada) {
		return modelMapper.map(listaCriada, ListaOutput.class);
	}

	public List<ListaOutput> entityToOutput(List<ListaEntity> listaEntity) {
		return listaEntity.stream().map(a -> this.entityToOutput(a)).collect(Collectors.toList());
	}

	
}
