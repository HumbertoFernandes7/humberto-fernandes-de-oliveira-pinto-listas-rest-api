package com.lista.rest.api.dto.inputs;

import javax.validation.constraints.NotBlank;

import com.lista.rest.api.entities.ListaEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemInput {

	@NotBlank(message = "Titulo é obrigatorio")
	private String titulo;

	private ListaEntity lista;
}
