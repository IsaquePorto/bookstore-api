package com.isaque.bookstore.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.isaque.bookstore.domain.Livro;
import com.isaque.bookstore.dtos.LivroDTO;
import com.isaque.bookstore.service.LivroService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/livros")
public class LivroController {

	@Autowired
	private LivroService service;

	@GetMapping("/{id}")
	public ResponseEntity<Livro> getLivro(@PathVariable Integer id) {
		Livro livro = service.getLivro(id);
		return ResponseEntity.ok().body(livro);
	}

	@GetMapping
	public ResponseEntity<List<LivroDTO>> findAll(
			@RequestParam(value = "categoria", defaultValue = "0") Integer catId) {

		List<Livro> livros = service.findAll(catId);
		List<LivroDTO> livrosDTO = livros.stream().map(obj -> new LivroDTO(obj)).collect(Collectors.toList());

		return ResponseEntity.ok().body(livrosDTO);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Livro> updateLivro(@PathVariable Integer id, @Valid @RequestBody Livro livro) {
		Livro newObj = service.updateLivro(id, livro);
		return ResponseEntity.ok().body(newObj);
	}

	@PatchMapping("/{id}")
	public ResponseEntity<Livro> updateLivroPatch(@PathVariable Integer id, @Valid @RequestBody Livro livro) {
		Livro newObj = service.updateLivro(id, livro);
		return ResponseEntity.ok().body(newObj);
	}

	@PostMapping
	public ResponseEntity<Livro> createLivro(@RequestParam(value = "categoria", defaultValue = "0") Integer idCat,
			@Valid @RequestBody Livro livro) {

		Livro novoLivro = service.create(idCat, livro);

		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/livros/{id}")
				.buildAndExpand(novoLivro.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteLivro(@PathVariable Integer id) {
		service.deleteLivro(id);
		return ResponseEntity.noContent().build();
	}
}
