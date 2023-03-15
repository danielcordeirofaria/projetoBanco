package br.com.banco.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.banco.model.Conta;
import br.com.banco.model.Movimentacao;
import br.com.banco.repo.IMovimentacaoRepo;

@Component
public class MovimentacaoServiceImpl implements IMovimentacaoService {

	@Autowired
	IMovimentacaoRepo repo;

	@Autowired
	IContaService service;

	@Override
	public Movimentacao cadastrarMovimentacao(Movimentacao m) {
		// TODO Auto-generated method stub
		if (m.getTipoOper() != -1 && m.getTipoOper() != 1) {
			return null;
		}

		Conta c = service.recuperarPeloNumero(m.getConta().getNumeroConta());
		if (c.getSaldo() > m.getValor()) {

			c.setSaldo(c.getSaldo() + m.getValor() * m.getTipoOper());

			service.alterarDados(c);

			return repo.save(m);
		}
		return null;
	}

	@Override
	public ArrayList<Movimentacao> recuperarTodas(int conta) {
		// TODO Auto-generated method stub
		Conta c = new Conta();
		c.setNumeroConta(conta);

		return (ArrayList<Movimentacao>) repo.findByConta(c);
	}

}
