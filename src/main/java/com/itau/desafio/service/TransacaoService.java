package com.itau.desafio.service;

import com.itau.desafio.model.Transacao;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class TransacaoService {

    private final List<Transacao> transacoes = new CopyOnWriteArrayList<>();
    
    public void adicionar(Transacao transacao) {
        System.out.println("SALVANDO TRANSACAO: valor=" + transacao.getValor()
                + " dataHora=" + transacao.getDataHora());
        transacoes.add(transacao);
    }


    public List<Transacao> listar() {
        return transacoes;
    }

    public void limpar() {
        transacoes.clear();
    }
}
