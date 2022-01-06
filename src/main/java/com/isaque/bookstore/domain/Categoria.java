package com.isaque.bookstore.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Categoria {
	 
	private int id;
	private String nome;
	private String descricao;
	
	private List<Livro> livros = new ArrayList<Livro>();
	
	public Categoria () {
		
	}
	
	public Categoria (int id, String nome, String descricao) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
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
