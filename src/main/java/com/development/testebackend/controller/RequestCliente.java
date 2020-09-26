package com.development.testebackend.controller;

import com.development.testebackend.model.Cliente;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

public interface RequestCliente {

    @GetMapping("/listar/clientes")
    ResponseEntity<?> listarClientes();

    @GetMapping("/pesquisar/cliente/{id}")
    ResponseEntity<?> Clienteespecifico(@PathVariable("id") int id);

    @PostMapping("/cadastrar/cliente")
    ResponseEntity<?> salvarCliente(@Validated @RequestBody Cliente cliente);

    @PutMapping("/atualizar/cliente/{id}")
    ResponseEntity<?> atualizarCliente(@PathVariable("id") int id, @Validated @RequestBody Cliente cliente);

    @DeleteMapping("/deletar/{id}")
    ResponseEntity<?> deletarCliente(@PathVariable("id") int id);

}
