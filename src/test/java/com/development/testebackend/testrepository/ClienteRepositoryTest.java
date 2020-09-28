package com.development.testebackend.testrepository;

import com.development.testebackend.model.Cliente;
import com.development.testebackend.repository.ClienteRepository;
import org.junit.Rule;

import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;



@RunWith(SpringRunner.class)
@DataJpaTest
public class ClienteRepositoryTest {
    @Autowired
    private ClienteRepository repository;

    @Rule
    public ExpectedException thrown = ExpectedException.none();


}
