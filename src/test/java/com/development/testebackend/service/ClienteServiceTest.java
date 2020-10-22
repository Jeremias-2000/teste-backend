package com.development.testebackend.service;

import com.development.testebackend.model.Cliente;
import com.development.testebackend.repository.ClienteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ClienteServiceTest {

    @Mock
    private ClienteRepository repo;
    @InjectMocks
    private ClienteService service;


    @Test
    void listar() {
       when(repo.findAll()).thenReturn(Stream.of(new Cliente(3,"Jeremias","jps@hotmail.com","Rua 13 de Março"))
               .collect(Collectors.toList()));
        assertEquals(1,service.listar().size());
    }

    @Test
    void procurarCliente() {
        Cliente cliente = new Cliente(3,"Jeremias","jps@hotmail.com","Rua 13 de Março");
        when(repo.findById(3)).thenReturn(Stream.of(cliente).findFirst());
        assertEquals(cliente,service.procurarCliente(3));
    }

    @Test
    void procurarClienteNome() {
    }

    @Test
    void procurarClienteEmail() {
    }

    @Test
    void cadastrarCliente() {
        Cliente cliente = new Cliente(1,"Jeremias","j@hotmail.com","Rua 13 de Março");
        when(repo.save(cliente)).thenReturn(cliente);
        assertEquals(cliente,service.cadastrarCliente(cliente));
    }

    @Test
    void atualizarCliente() {
    }

    @Test
    void deletar() {
    }

    @Nested
    class WhenListaring {
        @BeforeEach
        void setup() {
        }
    }

    @Nested
    class WhenProcuraringCliente {
        private final int ID = 63;

        @BeforeEach
        void setup() {
        }
    }

    @Nested
    class WhenProcuraringClienteNome {
        private final String NAME = "NAME";

        @BeforeEach
        void setup() {
        }
    }

    @Nested
    class WhenProcuraringClienteEmail {
        private final String EMAIL = "EMAIL";

        @BeforeEach
        void setup() {
        }
    }

    @Nested
    class WhenCadastraringCliente {
        @Mock
        private Cliente cliente;

        @BeforeEach
        void setup() {
        }
    }

    @Nested
    class WhenAtualizaringCliente {
        private final int ID = 92;
        @Mock
        private Cliente cliente;

        @BeforeEach
        void setup() {
        }
    }

    @Nested
    class WhenDeletaring {
        private final int ID = 14;

        @BeforeEach
        void setup() {
        }
    }
}