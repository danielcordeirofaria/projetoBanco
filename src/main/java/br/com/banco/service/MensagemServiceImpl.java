package br.com.banco.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("principal")
public class MensagemServiceImpl implements IMensagemService {

	@Override
	public String gerarUmaMensagem() {
		// TODO Auto-generated method stub
		return "Erro!!!";
	}

}