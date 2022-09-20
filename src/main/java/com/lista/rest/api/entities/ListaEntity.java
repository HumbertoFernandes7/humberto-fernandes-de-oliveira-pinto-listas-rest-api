package com.lista.rest.api.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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

	@Column(name = "titulo")
	private String titulo;

	@OneToMany(mappedBy = "lista")
	private List<ItemEntity> item;
	
	//@JoinTable(
	//name = "tb_lista_itens", joinColumns = @JoinColumn(
	//name = "item_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(
	//name = "lista_id", referencedColumnName = "id"))
}
