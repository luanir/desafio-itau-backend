package com.itau.desafio.controller;

import com.itau.desafio.model.Transacao;
import com.itau.desafio.service.TransacaoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    private final TransacaoService service;

    public TransacaoController(TransacaoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Void> criar(@Valid @RequestBody Transacao transacao) {

        if (transacao.getValor() == null || transacao.getDataHora() == null) {
            return ResponseEntity.badRequest().build();
        }

        if (transacao.getValor() < 0) {
            return ResponseEntity.unprocessableEntity().build();
        }

        // regra: não pode ser futura
        if (transacao.getDataHora().isAfter(Instant.now())) {
            return ResponseEntity.unprocessableEntity().build();
        }

        service.adicionar(transacao);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping
    public ResponseEntity<Void> limpar() {
        service.limpar();
        return ResponseEntity.ok().build();
    }
}
