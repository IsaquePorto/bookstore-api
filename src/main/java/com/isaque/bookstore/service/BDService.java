package com.isaque.bookstore.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isaque.bookstore.domain.Categoria;
import com.isaque.bookstore.domain.Livro;
import com.isaque.bookstore.repository.CategoriaRepository;
import com.isaque.bookstore.repository.LivroRepository;

@Service
public class BDService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private LivroRepository livroRepository;

	public void instanciaBancoDeDados() {
		Categoria cat1 = new Categoria("Informática", "Livros de Ti");
		Categoria cat2 = new Categoria("Biologia", "Livros de Biologia");
		Categoria cat3 = new Categoria("Ficção científica", "Livros de Ficção científica");

		Livro livro1 = new Livro("Clean Code", "Robert Martin", "Lorem Ipsun", cat1);
		Livro livro2 = new Livro("Guerra dos Mundos", "M.G. Wills", "Lorem Ipsun", cat3);
		Livro livro3 = new Livro("The Time Machine", "M.G. Wills", "Lorem Ipsun", cat3);
		Livro livro4 = new Livro("Scrum Arretado", "Daniel Abella", "Lorem Ipsun", cat1);

		cat1.getLivros().addAll(Arrays.asList(livro1, livro4));
		cat2.getLivros().addAll(Arrays.asList(livro2, livro3));

		this.categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		this.livroRepository.saveAll(Arrays.asList(livro1, livro2, livro3, livro4));
	}
}
