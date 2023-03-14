package br.com.banco.service;

import java.util.ArrayList;

import br.com.banco.model.Movimentacao;

public interface IMovimentacaoService {

	public Movimentacao cadastrarMovimentacao(Movimentacao m);
	
	public ArrayList<Movimentacao> recuperarTodas(int conta);
	
}
