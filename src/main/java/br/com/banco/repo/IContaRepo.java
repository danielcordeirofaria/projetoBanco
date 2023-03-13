package br.com.banco.repo;

import org.springframework.data.repository.CrudRepository;

import br.com.banco.model.Conta;

public interface IContaRepo extends CrudRepository<Conta, Integer> {

}
