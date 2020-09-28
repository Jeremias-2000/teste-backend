package com.development.testebackend.controller;

import com.development.testebackend.model.Cliente;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

public interface RequestCliente {

    @GetMapping("/listar")
    ResponseEntity<?> listarClientes();

    @GetMapping("/pesquisar/{id}")
    ResponseEntity<?> Clienteespecifico(@PathVariable("id") int id);

    @GetMapping("/pesquisar/nome/{nome}")
    ResponseEntity<?> buscarClienteNome(@PathVariable("nome") String nome);

    @GetMapping("/pesquisar/email/{email}")
    ResponseEntity<?> BuscarClienteEmail(@PathVariable("email") String email);

    @PostMapping("/cadastrar")
    ResponseEntity<?> salvarCliente(@Validated @RequestBody Cliente cliente);

    @PutMapping("/atualizar/{id}")
    ResponseEntity<?> atualizarCliente(@PathVariable("id") int id, @Validated @RequestBody Cliente cliente);

    @DeleteMapping("/deletar/{id}")
    ResponseEntity<?> deletarCliente(@PathVariable("id") int id);

}
