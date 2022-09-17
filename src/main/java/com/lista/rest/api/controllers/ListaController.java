package com.lista.rest.api.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lista.rest.api.configs.ControllerConfig;

@RestController
@RequestMapping(ControllerConfig.URL_API + "/lista")
@CrossOrigin(origins = "*")
public class ListaController {
	

//	@PostMapping
//	public void cadastraLista() {
//		
//	}
//	
//	@PutMapping
//	public void alteraLista() {
//		
//	}
//	
	@GetMapping
	public void listaTodasListas() {
		System.out.println("teste");
	}
//	
//	@GetMapping
//	public void listaPeloIdDaLista() {
//		
//	}
//	
//	@DeleteMapping
//	public void deletaLista() {
//		
//	}

}
