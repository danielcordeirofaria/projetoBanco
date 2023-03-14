package br.com.banco.repo;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import br.com.banco.model.Cliente;
import br.com.banco.model.Conta;

public interface IContaRepo extends CrudRepository<Conta, Integer> {

	ArrayList<Conta> findByTitular(Cliente c);

}
