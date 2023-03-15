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
	public ResponseEntity<?> recuperarContasPeloCliente(@PathVariable int id) {
		ArrayList<Conta> c = service.recuperarContasPeloCliente(id);
		if (c != null) {

			return ResponseEntity.ok(c);
		}
		return ResponseEntity.status(404).body(new MensagemErro(404, "Número não localizado!"));
	}

	@PostMapping("/contas")
	public ResponseEntity<?> adicionarConta(@RequestBody Conta c) {
		Conta res = service.adicionarContas(c);
		if (res != null) {
			return ResponseEntity.status(201).body(res);
		}
		return ResponseEntity.status(400).body(new MensagemErro(400, "Conta não cadastrada"));
	}
	
//	@PostMapping("/contas")
//	public ResponseEntity<?> adicionarConta(@RequestBody Conta c) {
//	    // Verificar se o cliente já existe
//	    Cliente cliente = serviceCliente.recuperarPeloCpf(c.getTitular().getCpf());
//	    if (cliente == null) {
//	        return ResponseEntity.status(400).body(new MensagemErro(400, "Cliente não cadastrado"));
//	    }
//	    // Verificar se a conta já existe
//	    Conta contaExistente = service.recuperarPeloNumero(c.getNumeroConta());
//	    if (contaExistente != null) {
//	        return ResponseEntity.status(400).body(new MensagemErro(400, "Conta já cadastrada"));
//	    }
//	    // Adicionar a nova conta
//	    Conta res = service.adicionarContas(c);
//	    if (res != null) {
//	        return ResponseEntity.status(201).body(res);
//	    }
//	    return ResponseEntity.status(400).body(new MensagemErro(400, "Conta não cadastrada"));
//	}
}