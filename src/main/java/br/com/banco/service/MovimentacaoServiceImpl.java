package br.com.banco.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.banco.model.Movimentacao;
import br.com.banco.repo.IMovimentacaoRepo;

@Component
public class MovimentacaoServiceImpl implements IMovimentacaoService {

	@Autowired
	IMovimentacaoRepo repo;

	@Override
	public Movimentacao cadastrarMovimentacao(Movimentacao m) {
		// TODO Auto-generated method stub
		return repo.save(m);
	}

	@Override
	public ArrayList<Movimentacao> recuperarTodas(int conta) {
		// TODO Auto-generated method stub
		return (ArrayList<Movimentacao>)repo.findAll(conta);
	}

}
