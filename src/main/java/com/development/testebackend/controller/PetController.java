package com.development.testebackend.controller;

import com.development.testebackend.model.Pet;
import com.development.testebackend.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.NoSuchElementException;

@RequestMapping("/api/v1/pet")
@RestController
public class PetController implements RequestPet{
    @Autowired
    private PetService service;

    @Override
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(service.listar(), HttpStatus.OK);

    }
    @Override
    public ResponseEntity<?> petEspecifico(int id)
    {
        try{
            Pet pet = service.procurarPet(id);
            return new ResponseEntity<>(pet, HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<Pet>(HttpStatus.NOT_FOUND);
        }

    }

    @Override
    public ResponseEntity<?> save(Pet pet) {
        service.cadastrarPet(pet);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }


    @Override
    public ResponseEntity<?> updatePet(int id, Pet pet) {
        try{
            service.atualizarPet(id,pet);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (NoSuchElementException e){
         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @Override
    public ResponseEntity<?> deletarPet(int id) {
        try {
            service.deletarPet(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
}
