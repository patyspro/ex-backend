package com.digitalhouse.escola.controller;


import com.digitalhouse.escola.model.Time;
import com.digitalhouse.escola.repository.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/time")
public class TimeController {

    @Autowired
    public TimeController(TimeRepository timeRepository) {
        this.timeRepository = timeRepository;
    }

    private TimeRepository timeRepository;

    @GetMapping
    private ResponseEntity<List<Time>> listarTodos(){

        return ResponseEntity.ok(timeRepository.findAll());
    }

    @GetMapping("/{id}")
    private ResponseEntity<Optional<Time>> consultaTime(@PathVariable(value = "id") Long timeId){

        return ResponseEntity.ok().body(timeRepository.findById(timeId));
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Long> deletarTodos(@PathVariable Long id){
        timeRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
