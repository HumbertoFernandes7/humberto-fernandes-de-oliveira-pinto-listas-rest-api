package com.lista.rest.api.dto.inputs;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ItemInput {

	@NotBlank(message = "Titulo é obrigatorio")
	@Length(max = 100, message = "O maximo de 100 caracteres permitidos")
	private String titulo;

	private Long listaId;
	
}
