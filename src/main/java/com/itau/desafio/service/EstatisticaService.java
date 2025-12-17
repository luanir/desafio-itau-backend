package com.itau.desafio.service;

import com.itau.desafio.model.Estatistica;
import com.itau.desafio.model.Transacao;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.DoubleSummaryStatistics;

@Service
public class EstatisticaService {
	
	private final TransacaoService transacaoService;
	
	public EstatisticaService(TransacaoService transacaoService) {
		this.transacaoService = transacaoService;
	}
	
	public Estatistica calcular() {
		OffsetDateTime limite = OffsetDateTime.now().minusSeconds(60);
		
		DoubleSummaryStatistics stats = transacaoService.listar().stream()
				.filter(t -> t.getDataHora().isAfter(limite))
				.mapToDouble(Transacao::getValor)
				.summaryStatistics();
		
		if(stats.getCount() == 0) {
			return new Estatistica(0, 0, 0, 0, 0);
		}
		
		return new Estatistica(
				stats.getCount(),
				stats.getSum(),
				stats.getAverage(),
				stats.getMin(),
				stats.getMax()				
		);
	}
}
