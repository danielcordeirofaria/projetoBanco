package br.com.banco.repo;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import br.com.banco.model.Conta;
import br.com.banco.model.Movimentacao;

public interface IMovimentacaoRepo extends CrudRepository<Movimentacao, Integer>{


	ArrayList<Movimentacao> findByConta(Conta  conta);

	ArrayList<Movimentacao> findByContaAndDataMovimBetween(Conta c, LocalDate dataIni, LocalDate dataFim);
	
}
