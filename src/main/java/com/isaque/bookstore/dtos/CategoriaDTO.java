package com.isaque.bookstore.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.isaque.bookstore.domain.Categoria;

public class CategoriaDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotEmpty(message = "Campo NOME é requerido.") 
	@Length(min = 3, max = 100, message = "Campo nome deve ter entre 3 e 100 caracteres" )
	private String nome;
	
	@NotEmpty(message = "Campo DESCRICAO é requerido.") 
	@Length(min = 3, max = 200, message = "Campo DESCRICAO deve ter entre 3 e 200 caracteres" )
	private String descricao;
	
	public CategoriaDTO() {
		super();
	}

	public CategoriaDTO(Categoria cat) {
		super();
		this.id = cat.getId();
		this.nome = cat.getNome();
		this.descricao = cat.getDescricao();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
