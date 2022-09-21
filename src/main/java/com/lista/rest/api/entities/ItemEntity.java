package com.lista.rest.api.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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

	@Column(name = "titulo")
	private String titulo;
	
	@Column(name = "concluido")
	private Boolean concluido;
	
	@ManyToOne
	private ListaEntity lista;

	
	
		//@JoinTable(
		//name = "tb_lista_itens", joinColumns = @JoinColumn(
		//name = "item_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(
		//name = "lista_id", referencedColumnName = "id"))

}
