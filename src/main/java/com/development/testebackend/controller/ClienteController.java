package com.development.testebackend.controller;

import com.development.testebackend.model.Cliente;

import com.development.testebackend.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
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
    public ResponseEntity<?> buscarClienteNome(String nome) {
        List<Cliente> searchName = service.procurarClienteNome(nome);
        try {
            return new ResponseEntity<>(searchName,HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @Override
    public ResponseEntity<?> BuscarClienteEmail(String email) {
        List<Cliente> searchEmail = service.procurarClienteEmail(email);
        try{
            return new ResponseEntity<>(searchEmail,HttpStatus.OK);
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

            return new ResponseEntity<>(service.atualizarCliente(id, cliente),HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<?> deletarCliente(int id) {
        try {
            return new ResponseEntity<>(service.deletar(id),HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
