package br.com.banco.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
	
	@GetMapping("/") 
	public String sayWelcome() {
		return "<pre>"
		+ " Bem vindo a API do banco!!!<br/>"
		+ " Lista de EndPoints disponiveis: <br/>"
		+ " Clientes:<br/>"	
		+ " /clientes (GET) - Para recuperar todos os clientes.<br/>"
		+ " /cliente/{id} (GET) - Para recuperar o cliente pelo id.<br/>"
		+ " /clientes (POST) - Para cadastrar um novo cliente.<br/>"
		+ " Contas:<br/>"
		+ " /contas/id (GET) - Para recuperar uma conta pelo id.<br/>"
		+ " /contas/cliente/id (GET) - Para recuperar as contas de determinado cliente pelo id.<br/>"
		+ " /contas (post) - Para cadastrar uma nova conta.<br/>"
		+ " Movimentações:<br/>"
		+ " /movimentacao/id (GET) - Recupera as movimentações de uma determinada conta pelo id.</br>"
		+ " /movimentacao (POST) - Para cadastrar uma nova movimentação.</pre>";
	}

}
