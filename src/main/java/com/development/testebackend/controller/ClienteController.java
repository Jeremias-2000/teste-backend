package com.development.testebackend.controller;

import com.development.testebackend.model.Cliente;
import com.development.testebackend.repository.ClienteRepository;
import com.development.testebackend.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.NoSuchElementException;

@RequestMapping("/api/v1/cliente")
@RestController
public class ClienteController implements RequestCliente{

    @Autowired
    private ClienteService service;

    @Override
    public ResponseEntity<?> listarClientes() {
        try {
            return new ResponseEntity<>(service.listar(), HttpStatus.OK);
        }catch (NoClassDefFoundError e){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    }

    @Override
    public ResponseEntity<?> Clienteespecifico(int id) {
        try{
            Cliente cliente = service.procurarCliente(id);

            return new ResponseEntity<>(cliente, HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @Override
    public ResponseEntity<?> salvarCliente(Cliente cliente) {
        return new ResponseEntity<>(service.cadastrarCliente(cliente),HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> atualizarCliente(int id, Cliente cliente) {
        try {
            service.atualizarCliente(id, cliente);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<?> deletarCliente(int id) {
        try {
            service.deletar(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
