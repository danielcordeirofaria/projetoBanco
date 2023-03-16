package br.com.banco.service;

import java.util.ArrayList;

import br.com.banco.model.Conta;

public interface IContaService {

	public Conta adicionarContas(Conta c);

	public Conta recuperarPeloNumero(int numero);

	public Conta alterarDados(Conta c);

	public ArrayList<Conta> recuperarContasPeloCliente(int idCliente);
}
