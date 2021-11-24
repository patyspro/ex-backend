package com.digitalhouse.escola.controller;

import com.digitalhouse.escola.model.Jogador;
import com.digitalhouse.escola.repository.JogadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jogador")


public class JogadorController {

    @Autowired
    public JogadorController(JogadorRepository jogadorRepository) {
        this.jogadorRepository = jogadorRepository;
    }

    private JogadorRepository jogadorRepository;
    @PostMapping
    private ResponseEntity<Jogador> cadastraJogador(@RequestBody Jogador jogador){
        return ResponseEntity.status(HttpStatus.CREATED).body(jogadorRepository.save(jogador));
    }

    @GetMapping
    private ResponseEntity<List<Jogador>> listarTodos(){
        return ResponseEntity.ok(jogadorRepository.findAll());
    }




}
