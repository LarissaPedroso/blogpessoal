package com.generation.blogpessoal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.blogpessoal.model.Postagem;
import com.generation.blogpessoal.repository.PostagemRepository;

@RestController
@RequestMapping("/postagem")
@CrossOrigin(origins = "*",  allowedHeaders="*") //quem pode acessar essa rota, posso restringir, * significa que toda e qualquer origem pode acessar 
public class PostagemController {
	
	//injeção de dependencias de forma automatica 
	@Autowired
	private PostagemRepository postagemRepository;
	
	//acessado pelo verbo get
	@GetMapping
	public ResponseEntity<List<Postagem>> getAll(){
		//find all == select * from nomedatabela
		//reponseentity traz a resposta no formato http
		return ResponseEntity.ok(postagemRepository.findAll());
	}
	
	/*@GetMapping("/exemplo")
	public ResponseEntity<String> exemplo(){
		String ola = "Olá, mundo";
		return ResponseEntity.ok(ola);
	}*/
}
