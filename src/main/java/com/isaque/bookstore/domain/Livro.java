package com.isaque.bookstore.domain;

import lombok.Data;

@Data
public class Livro {
	
	private int id;
	private String titulo;
	private String nomeAutor;
	private String texto;
	
	private Categoria categoria;
	
	public Livro () {
		
	}

	public Livro(int id, String titulo, String nomeAutor, String texto, Categoria categoria) {
		this.id = id;
		this.titulo = titulo;
		this.nomeAutor = nomeAutor;
		this.texto = texto;
		this.categoria = categoria;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livro other = (Livro) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	
	
}
