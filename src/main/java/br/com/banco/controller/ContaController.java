package br.com.banco.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.banco.dto.MensagemErro;
import br.com.banco.model.Cliente;
import br.com.banco.model.Conta;
import br.com.banco.service.IContaService;

@RestController
public class ContaController {
	
	@Autowired
	private IContaService service;
	
	@GetMapping("/contas/{id}")
	public ResponseEntity<?> recuperarPeloNumero(@PathVariable int id) {
		Conta c = service.recuperarPeloNumero(id);
		if (c != null) {
			return ResponseEntity.ok(c);
		}
		return ResponseEntity.status(404).body(new MensagemErro(404, "Número não localizado!"));
	}
	
	@GetMapping("/contas/cliente/{id}")
	public ArrayList<Conta> recuperarContasPeloCliente(@PathVariable int id) {
		Cliente c = new Cliente();
		c.setIdCliente(id);
		return service.recuperarContasPeloCliente(c);
	}
}
