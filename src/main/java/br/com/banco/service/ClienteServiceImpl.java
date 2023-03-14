package br.com.banco.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.banco.model.Cliente;
import br.com.banco.repo.IClienteRepo;

@Component
public class ClienteServiceImpl implements IClienteService {

	@Autowired
	private IClienteRepo repo;
	
	@Override
	public Cliente cadastrarCliente(Cliente c) {
		// TODO Auto-generated method stub
		return repo.save(c);
	}

	@Override
	public ArrayList<Cliente> recuperarTodos() {
		// TODO Auto-generated method stub
		return (ArrayList<Cliente>)repo.findAll();
	}

	@Override
	public Cliente recuperarPeloId(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElse(null);
	}

}
