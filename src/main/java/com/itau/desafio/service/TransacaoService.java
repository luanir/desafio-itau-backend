package com.itau.desafio.service;

import com.itau.desafio.model.Transacao;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransacaoService {

	private final List<Transacao> transacoes = new ArrayList<>();
	
	public void adicionar(Transacao transacao) {
		transacoes.add(transacao);
	}
	
	public List<Transacao> listar() {
		return transacoes;
	}
	
	public void limpar() {
		transacoes.clear();
	}
}
