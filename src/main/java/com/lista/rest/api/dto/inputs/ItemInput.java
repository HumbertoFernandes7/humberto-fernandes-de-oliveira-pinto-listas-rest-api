package com.lista.rest.api.dto.inputs;

import com.lista.rest.api.entities.ListaEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemInput {

	private String titulo;
	
	private Boolean concluido;
	
	private ListaEntity lista;
}

