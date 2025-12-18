package com.itau.desafio.service;

import com.itau.desafio.model.Estatistica;
import com.itau.desafio.model.Transacao;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.DoubleSummaryStatistics;
import java.util.List;

@Service
public class EstatisticaService {

    private final TransacaoService transacaoService;

    public EstatisticaService(TransacaoService transacaoService) {
        this.transacaoService = transacaoService;
    }

    public Estatistica calcular() {

        System.out.println("TOTAL TRANSACOES NA MEMORIA: "
                + transacaoService.listar().size());

        Instant limite = Instant.now().minusSeconds(60);
        System.out.println("LIMITE: " + limite);

        List<Transacao> validas = transacaoService.listar().stream()
                .filter(t -> {
                    System.out.println("TRANSACAO: " + t.getDataHora());
                    return t.getDataHora().isAfter(limite);
                })
                .toList();

        System.out.println("TRANSACOES VALIDAS: " + validas.size());

        DoubleSummaryStatistics stats = validas.stream()
                .mapToDouble(Transacao::getValor)
                .summaryStatistics();

        return new Estatistica(
                stats.getCount(),
                stats.getSum(),
                stats.getAverage(),
                stats.getCount() == 0 ? 0.0 : stats.getMin(),
                stats.getCount() == 0 ? 0.0 : stats.getMax()
        );
    }

}
