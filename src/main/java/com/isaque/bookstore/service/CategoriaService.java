package com.isaque.bookstore.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isaque.bookstore.domain.Categoria;
import com.isaque.bookstore.repository.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repository;
	
	public Categoria findById(int id) {
		Optional<Categoria> obj = repository.findById(id);
		return obj.orElse(null);
	}
	
	
	
}
