package com.isaque.bookstore.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isaque.bookstore.domain.Categoria;
import com.isaque.bookstore.service.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {
	
	@Autowired
	private CategoriaService service;
	
	@GetMapping("/{id}")
	public ResponseEntity<Categoria> findById(@PathVariable int id){
		Categoria obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
