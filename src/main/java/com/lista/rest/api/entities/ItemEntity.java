package com.lista.rest.api.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "tb_item")
public class ItemEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@NotBlank(message = "Titulo é obrigatorio")
	@Length(max = 100, message = "O maximo de 100 caracteres permitidos")
	@Column(name = "titulo")
	private String titulo;
	
	@NotNull(message = "Concluido é obrigatorio")
	@Column(name = "concluido")
	private Boolean concluido;
	
	//@NotNull(message = "Id da lista é obrigatorio")
	@ManyToOne
	@JoinColumn(name = "lista_id")
	private ListaEntity lista;
	
	

}
