package com.development.testebackend.service;

import com.development.testebackend.model.Cliente;
import com.development.testebackend.repository.ClienteRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    ClienteRepository repo;

    public List<Cliente> listar(){
        return  repo.findAll();
    }
    public Cliente procurarCliente(int id){
        return repo.findById(id).orElse(null);
    }
    public List<Cliente> procurarClienteNome(String name){
        List<Cliente> search = repo.findByNameStartingWith(name);
        if (search == null){
            return null;
        }
        return search;
    }
    public List<Cliente> procurarClienteEmail(String email){
            List<Cliente> search = repo.findByEmailStartingWith(email);
            if (search == null){
                return null;
            }
            return search;
    }

    public String cadastrarCliente(Cliente cliente){
        repo.save(cliente);
        return "Cadastro efetuado com sucesso !";
    }

    public String atualizarCliente(int id, Cliente cliente){
        Cliente existsCliente = repo.findById(id).orElse(null);
        if (existsCliente == null){
            return "Cliente não encontrado !";
        }else{
            existsCliente.setName(cliente.getName());
            existsCliente.setEmail(cliente.getEmail());
            existsCliente.setAdress(cliente.getAdress());
            repo.save(existsCliente);
            return "Atualização finalizada com sucesso";
        }
    }

    public String deletar(int id){
        Cliente cliente = repo.findById(id).orElse(null);
        if (cliente == null){
            return "Cliente não encontrado";
        }
        repo.delete(cliente);
        return "Cliente deletado com sucesso !";


    }


}
