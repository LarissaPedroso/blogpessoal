package com.generation.blogpessoal.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
// @Entity indica que esta Classe define uma entidade, ou seja, ela será utilizada para gerar uma tabela no Banco de dados da aplicação.
@Table(name = "tb_temas")
public class Tema {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //chave primária gerada pela JPA
	private Long id;
	
	@NotNull(message = "O atributo descrição é obrigatório")
	private String descricao;
	
	// fetch define a estratégia de busca. Temos dois: Lazy e Eager
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tema", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("tema")
	private List<Postagem> postagem;
	
	public Long getId() {
		return this.id;
	}
	
	public void setID(Long id) {
		this.id = id;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public List<Postagem> getPostagem(){
		return postagem;
	}
	
	public void setPostagem(List<Postagem> postagem) {
		this.postagem = postagem; 
	}
}
