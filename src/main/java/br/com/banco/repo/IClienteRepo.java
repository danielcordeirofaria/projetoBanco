package br.com.banco.repo;

import org.springframework.data.repository.CrudRepository;

import br.com.banco.model.Cliente;

public interface IClienteRepo extends CrudRepository<Cliente, Integer> {

}
