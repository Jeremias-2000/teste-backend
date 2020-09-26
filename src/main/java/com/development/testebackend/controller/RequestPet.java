package com.development.testebackend.controller;

import com.development.testebackend.model.Pet;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

public interface RequestPet {

    @GetMapping("/listar")
    ResponseEntity<?> getAll();

    @GetMapping("/pesquisar/{id}")
    ResponseEntity<?> petEspecifico(@PathVariable("id") int id);

    @PostMapping("/cadastrar")
    ResponseEntity<?> save(@Validated @RequestBody Pet pet);

    @PutMapping("/atualizar/{id}")
    ResponseEntity<?> updatePet(@PathVariable("id") int id, @Validated @RequestBody Pet pet);

    @DeleteMapping("/deletar/{id}")
    ResponseEntity<?> deletarPet(@PathVariable("id") int id);
}
