package com.development.testebackend.service;

import com.development.testebackend.model.Pet;

import com.development.testebackend.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {

    @Autowired
    PetRepository repository;

    public List<Pet> listar(){
        return repository.findAll();
    }

    public String procurarPet(int id){
       Pet search = repository.findById(id).orElse(null);
       if (search == null){
           return "Pet não encontrado" + id;
       }
       return "Pet encontrado \n" + search;
    }



    public String cadastrarPet(Pet pet) {
        repository.save(pet);
        return "cadastro efetuado com sucesso !";
    }

    public String atualizarPet(int id, Pet update) {
        Pet search = repository.findById(id).orElse(null);
        if (search == null) {
            return "Pet não encontrado !";
        } else {
            search.setNome(update.getNome());
            search.setRaca(update.getRaca());
            search.setTamanho(update.getTamanho());
            repository.save(search);
            return "Atualização finalizada com sucesso !";
        }
    }
    public String deletarPet(int id){
        Pet search = repository.findById(id).orElse(null);
        if (search == null){
            return "Pet não encontrado !";
        }
        repository.delete(search);
        return "Pet deletado com sucesso !";
    }

}
