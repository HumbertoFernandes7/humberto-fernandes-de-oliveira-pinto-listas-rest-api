package com.lista.rest.api.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.tags.Tag;

@Configuration
public class OpenAPIConfig {

	@Bean
	public OpenAPI springShopOpenAPI() {
		OpenAPI openAPI = new OpenAPI();
		
		Info info = new Info();
		info.title(" Avaliação 03 Lista G&P");
		info.version("v0.0.1");
		info.description("<h2>Sistema de Listas e Itens G&P</h2>");
		openAPI.info(info);
		openAPI.addTagsItem(new Tag().name("Lista").description("Gerencia as Listas do sistema"));
		openAPI.addTagsItem(new Tag().name("Item").description("Gerencia os Itens do sistema"));
		
		return openAPI;
	}
}