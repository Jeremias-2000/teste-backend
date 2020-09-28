package com.development.testebackend.repository;

import com.development.testebackend.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Integer> {
    List<Cliente> findByNameStartingWith (String name);
    List<Cliente> findByEmailStartingWith(String email);
}
