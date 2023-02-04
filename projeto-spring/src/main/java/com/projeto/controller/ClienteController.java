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
import com.projeto.model.Cliente;
import com.projeto.repository.ClienteRepository;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;
	@GetMapping
	public List<Cliente> listar() {
		return clienteRepository.findAll();				
	}
	
	
	@GetMapping("/{id}")
	public Cliente getClienteById(@PathVariable Long id) {
		return clienteRepository.findById(id).get();
	}
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente adicionar(@RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	@DeleteMapping("/{id}")
	public void deleteCarro(@PathVariable Long id) {
		clienteRepository.deleteById(id);
	}
	
	@PutMapping("/{id}")
	@ResponseBody
		public ResponseEntity<Cliente> atualizar(@RequestBody Cliente cliente){
		Cliente clie = clienteRepository.saveAndFlush(cliente);
		return new ResponseEntity<Cliente>(clie, HttpStatus.OK);
	}
	
}
