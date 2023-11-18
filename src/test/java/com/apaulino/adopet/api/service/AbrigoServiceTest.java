package com.apaulino.adopet.api.service;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.apaulino.adopet.api.model.Abrigo;
import com.apaulino.adopet.api.repository.AbrigoRepository;
import com.apaulino.adopet.api.repository.PetRepository;

@ExtendWith(MockitoExtension.class)
class AbrigoServiceTest {

    @InjectMocks
    private AbrigoService service;

    @Mock
    private AbrigoRepository repository;

    @Mock
    private Abrigo abrigo;

    @Mock
    private PetRepository petRepository;

    @Test
    void deveriaChamarListaDeTodosOsAbrigos() {
        service.listar();

        then(repository).should().findAll();
    }

    @Test
    void deveriaChamarListaDePetsDoAbrigoAtravesDoNome() {
        String nome = "Miau";
        given(repository.findByNome(nome)).willReturn(Optional.of(abrigo));

        service.listarPetsDoAbrigo(nome);

        then(petRepository).should().findByAbrigo(abrigo);
    }

}