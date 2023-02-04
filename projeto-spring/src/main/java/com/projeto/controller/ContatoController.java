package com.projeto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.projeto.model.Contato;
import com.projeto.repository.ClienteRepository;
import com.projeto.repository.ContatoRepository;

import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/contatos")
public class ContatoController {

	@Autowired
	private ContatoRepository contatoRepository;
	@GetMapping
	public List<Contato> listar() {
		return contatoRepository.findAll();				
	}
	
	
	@GetMapping("/{id}")
	public Contato getClienteById(@PathVariable Long id) {
		return contatoRepository.findById(id).get();
	}
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Contato adicionar(@RequestBody Contato contato) {
		return contatoRepository.save(contato);
	}
	
	@DeleteMapping("/{id}")
	public void deleteCarro(@PathVariable Long id) {
		contatoRepository.deleteById(id);
	}
	
	@PutMapping("/{id}")
	@ResponseBody
		public ResponseEntity<Contato> atualizar(@RequestBody Contato contato){
		Contato cont = contatoRepository.saveAndFlush(contato);
		return new ResponseEntity<Contato>(cont, HttpStatus.OK);
	}
	
}
