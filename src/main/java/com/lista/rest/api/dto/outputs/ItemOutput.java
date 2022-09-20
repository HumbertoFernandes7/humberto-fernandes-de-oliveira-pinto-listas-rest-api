package com.lista.rest.api.dto.outputs;

import com.lista.rest.api.entities.ListaEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemOutput {

	private Long id;
	
	private String titulo;
	
	private Boolean concluido;
	
	private ListaEntity lista;
}
