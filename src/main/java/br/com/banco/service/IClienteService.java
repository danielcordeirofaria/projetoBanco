package br.com.banco.service;

import java.util.ArrayList;

import br.com.banco.model.Cliente;

public interface IClienteService {

	public Cliente cadastrarCliente(Cliente c);
	
	public ArrayList<Cliente> recuperarTodos();
	
	public Cliente recuperarPeloId(int id);
}
