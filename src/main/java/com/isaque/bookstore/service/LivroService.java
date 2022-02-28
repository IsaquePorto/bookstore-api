package com.isaque.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isaque.bookstore.domain.Categoria;
import com.isaque.bookstore.domain.Livro;
import com.isaque.bookstore.repository.LivroRepository;
import com.isaque.bookstore.service.exceptions.ObjectNotFoundException;

@Service
public class LivroService {

	@Autowired
	private LivroRepository repository;
	
	@Autowired
	private CategoriaService categoriaService;

	public Livro getLivro(Integer id) {
		Optional<Livro> livro = repository.findById(id);
		return livro.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}
	
	public List<Livro> findAll(Integer idCat){
		categoriaService.findById(idCat);
		return repository.findAllByCategoria(idCat);
	}
	
	public Livro updateLivro(Integer id, Livro novoLivro) {
		Livro livro = getLivro(id);
		updateData(livro, novoLivro);
		return repository.save(livro);
	}

	private void updateData(Livro livro, Livro novoLivro) {
		if(novoLivro.getNomeAutor() != null) {
			livro.setNomeAutor(novoLivro.getNomeAutor());
		}
		if(novoLivro.getTexto() != null) {
			livro.setTexto(novoLivro.getTexto());
		}
		if(novoLivro.getTitulo() != null) {
			livro.setTitulo(novoLivro.getTitulo());
		}
	}

	public Livro create(Integer idCat, Livro livro) {
		
		livro.setId(null);
		Categoria cat = categoriaService.findById(idCat);
		livro.setCategoria(cat);
		return repository.save(livro);
	}

	public void deleteLivro(Integer id) {
		Livro livro = getLivro(id);
		repository.delete(livro);
		
	}
}
