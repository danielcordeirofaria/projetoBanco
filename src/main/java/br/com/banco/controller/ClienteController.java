package br.com.banco.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.banco.dto.MensagemErro;
import br.com.banco.model.Cliente;
import br.com.banco.service.IClienteService;

@RestController
public class ClienteController {

	@Autowired
	private IClienteService service;

	@GetMapping("/clientes")
	public ArrayList<Cliente> recuperarTodos() {
		return service.recuperarTodos();
	}

	@GetMapping("/clientes/{id}")
	public ResponseEntity<?> recuperarPeloId(@PathVariable int id) {
		Cliente c = service.recuperarPeloId(id);
		if (c != null) {
			return ResponseEntity.ok(c);
		}
		return ResponseEntity.status(404).body(new MensagemErro(404, "Cliente não existe!"));
	}

	@PostMapping("/clientes")
	public ResponseEntity<?> cadastrarCliente(@RequestBody Cliente c) {
		Cliente res = service.cadastrarCliente(c);
		if (res != null) {
			return ResponseEntity.status(201).body(res);
		}
		return ResponseEntity.status(400).body(new MensagemErro(400, "Falha ao cadastrar cliente!"));
	}

	
}
