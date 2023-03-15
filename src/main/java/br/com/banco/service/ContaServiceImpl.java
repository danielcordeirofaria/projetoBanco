package br.com.banco.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.banco.model.Cliente;
import br.com.banco.model.Conta;
import br.com.banco.repo.IContaRepo;

@Component
public class ContaServiceImpl implements IContaService {

	@Autowired
	IContaRepo repo;

	@Override
	public Conta adicionarContas(Conta c) {
		// TODO Auto-generated method stub
		if (c.getTipoConta() > 3 || c.getTipoConta() < 1) {
			return null;
		}
		return repo.save(c);
	}

	@Override
	public Conta recuperarPeloNumero(int numero) {
		// TODO Auto-generated method stub
		return repo.findById(numero).orElse(null);
	}

	@Override
	public Conta alterarDados(Conta c) {
		// TODO Auto-generated method stub
		if (c.getNumeroConta() == 0) {
			return null;
		}
		return repo.save(c);
	}

	@Override
	public ArrayList<Conta> recuperarContasPeloCliente(int idCliente) {
		// TODO Auto-generated method stub
		Cliente c = new Cliente();
		c.setIdCliente(idCliente);
		return repo.findByTitular(c);
	}

}
