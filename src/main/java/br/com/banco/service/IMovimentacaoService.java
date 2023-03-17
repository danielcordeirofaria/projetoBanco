package br.com.banco.service;

import java.time.LocalDate;
import java.util.ArrayList;

import br.com.banco.model.Conta;
import br.com.banco.model.Movimentacao;

public interface IMovimentacaoService {

	public Movimentacao cadastrarMovimentacao(Movimentacao m);
	
	public ArrayList<Movimentacao> recuperarTodas(int conta);

	public boolean transferirValores(int contaOrigem, int contaDestino, double valor);
	
	public ArrayList<Movimentacao> listarMovimentos(int c, String strIni, String strFim);
}
