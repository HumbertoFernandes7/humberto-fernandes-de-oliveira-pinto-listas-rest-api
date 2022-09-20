package com.lista.rest.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lista.rest.api.entities.ItemEntity;
import com.lista.rest.api.repositories.ItemRepository;

@Service
public class ItemService {

	
	@Autowired
	private ItemRepository itemRepository;

	public ItemEntity cadastra(ItemEntity item) {
		return itemRepository.save(item);
	}

	public List<ItemEntity> itemTodas() {
		return itemRepository.findAll();
	}

	public ItemEntity buscaItemPorId(Long id) {
		return itemRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Não foi encontrado o Id " + id));
	}

	public void deletaItem(ItemEntity itemEncontrada) {
		itemRepository.delete(itemEncontrada);
	}

	public ItemEntity alteraItem(ItemEntity item) {
		return itemRepository.save(item);
	}
}
