package br.com.banco.service;

import java.sql.Date;
import java.time.LocalDate;
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
		if (m.getTipoOper() == -1 && c.getSaldo() >= m.getValor() && m.getValor() > 0) {

			c.setSaldo(c.getSaldo() + m.getValor() * m.getTipoOper());

			service.alterarDados(c);

			return repo.save(m);
		} else if (m.getTipoOper() == 1 && m.getValor() > 0) {

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

	@Override
	public boolean transferirValores(int contaOrigem, int contaDestino, double valor) {
		// TODO Auto-generated method stub
		Conta origem = service.recuperarPeloNumero(contaOrigem);
		Conta destino = service.recuperarPeloNumero(contaDestino);

		if (origem.getSaldo() >= valor && valor > 0) {
			origem.setSaldo(origem.getSaldo() - valor);
			destino.setSaldo(destino.getSaldo() + valor);

			service.alterarDados(origem);
			service.alterarDados(destino);

			Movimentacao m = new Movimentacao();
			m.setTipoOper(-1);
			m.setConta(origem);
			m.setValor(valor);
			m.setDataMovim(LocalDate.now());
			repo.save(m);

			Movimentacao m2 = new Movimentacao();
			m2.setTipoOper(1);
			m2.setConta(destino);
			m2.setValor(valor);
			m2.setDataMovim(LocalDate.now());
			repo.save(m2);

			return true;
		}

		return false;
	}

	@Override
	public ArrayList<Movimentacao> listarMovimentos(int conta, String strIni, String strFim) {
		// TODO Auto-generated method stub
		Conta c = new Conta();
		c.setNumeroConta(conta);

		LocalDate dIni = LocalDate.parse(strIni);

		LocalDate dFim = LocalDate.parse(strFim);

		return (ArrayList<Movimentacao>) repo.findByContaAndDataMovimBetween(c, dIni, dFim);
	}

}
