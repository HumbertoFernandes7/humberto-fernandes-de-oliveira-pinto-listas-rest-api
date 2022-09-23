package com.lista.rest.api.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "tb_lista")
public class ListaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@NotBlank(message = "Titulo é obrigatorio")
	@Length(max = 100, message = "O maximo de 100 caracteres permitidos")
	@Column(name = "titulo")
	private String titulo;

	@OneToMany(mappedBy = "lista", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<ItemEntity> itens;
	

}
