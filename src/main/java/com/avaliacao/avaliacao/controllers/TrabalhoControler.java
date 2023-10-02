package com.avaliacao.avaliacao.controllers;

import com.avaliacao.avaliacao.models.Trabalho;
import com.avaliacao.avaliacao.repositories.TrabalhoReppository;
import com.avaliacao.avaliacao.services.TrabalhoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin()
@RequestMapping("/trabalho")
public class TrabalhoControler {

    final private TrabalhoReppository trabalhoReppository;

    final private TrabalhoService trabalhoService;


    public TrabalhoControler(TrabalhoReppository trabalhoReppository, TrabalhoService trabalhoService) {
        this.trabalhoReppository = trabalhoReppository;
        this.trabalhoService = trabalhoService;
    }

    @PostMapping
    public ResponseEntity<Object> novoChecklist(@RequestBody Trabalho trabalho) {
        return ResponseEntity.status(HttpStatus.CREATED).body(trabalhoService.criar(trabalho));
    }

    @GetMapping
    public ResponseEntity<List<Trabalho>> buscarTodos() {
        return ResponseEntity.status(HttpStatus.OK).body(trabalhoService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> buscarPorId(@PathVariable("id") Long id) {
        Trabalho trabalhoOptional = trabalhoService.findByIdTrabalho(id);
        if (trabalhoOptional == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Trabalho não encontrado!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(trabalhoOptional);
    }

    @GetMapping(value = "/titulo/{titulo}/nota/{nota}")
    public ResponseEntity<Object> buscarPorId(@PathVariable("titulo") String titulo,
                                              @PathVariable ("nota") Integer nota) {
        List<Trabalho> trabalhoOptional = trabalhoService.buscarTrabalhosPorPalavraChaveENota
                (titulo, nota);

        return ResponseEntity.status(HttpStatus.OK).body(trabalhoOptional);
    }


}
