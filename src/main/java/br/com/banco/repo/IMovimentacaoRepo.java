package br.com.banco.repo;

import org.springframework.data.repository.CrudRepository;

import br.com.banco.model.Movimentacao;

public interface IMovimentacaoRepo extends CrudRepository<Movimentacao, Integer>{

	
	
}
