package com.isaque.bookstore.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
@Entity
public class Categoria implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty(message = "Campo NOME é requerido.") 
	@Length(min = 3, max = 100, message = "Campo nome deve ter entre 3 e 100 caracteres" )
	private String nome;
	
	@NotEmpty(message = "Campo DESCRICAO é requerido.") 
	@Length(min = 3, max = 200, message = "Campo DESCRICAO deve ter entre 3 e 200 caracteres" )
	private String descricao;

	@OneToMany(mappedBy = "categoria")
	private List<Livro> livros = new ArrayList<Livro>();

	public Categoria() {

	}

	public Categoria(String nome, String descricao) {
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
