package br.com.banco.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.banco.dto.MensagemErro;
import br.com.banco.model.Movimentacao;
import br.com.banco.service.IMovimentacaoService;

@RestController
public class MovimentacaoController {
	
	@Autowired
	IMovimentacaoService service;
	
	@PostMapping("/movimentacao")
	public ResponseEntity<?> cadastrarMovimentacao(@RequestBody Movimentacao m){
		Movimentacao res = service.cadastrarMovimentacao(m);
		if(res != null) {
			return ResponseEntity.status(201).body(res);
		}
		return ResponseEntity.status(400).body(new MensagemErro(400, "Operação não realizada"));
	}
	
	@GetMapping("/movimentacao/{id}")
	public ArrayList<Movimentacao> recuperarTodas(@RequestBody Movimentacao m){
		return null;
	}
}
