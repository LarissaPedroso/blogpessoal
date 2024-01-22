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
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_usuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O nome é obrigatório.")
	private String nome;
	
	@NotBlank(message = "O usuário é obrigatório.")
	@Email(message =  "O email deve ser um email válido.")
	private String usuario;
	
	@NotBlank(message = "A senha é obrigatória")
	@Size(min = 8, message = "A senha precisa conter no mínimo 8 caracteres.")
	private String senha;
	
	@Size(max = 5000, message = "O link da foto deve conter no máximo 5000 caracteres")
	private String foto;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("usuario")
	private List<Postagem> postagem;

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getUsuario() {
		return usuario;
	}

	public String getSenha() {
		return senha;
	}

	public String getFoto() {
		return foto;
	}

	public List<Postagem> getPostagem() {
		return postagem;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public void setPostagem(List<Postagem> postagem) {
		this.postagem = postagem;
	}
}
