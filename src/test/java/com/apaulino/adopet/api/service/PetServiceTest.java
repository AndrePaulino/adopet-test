package com.apaulino.adopet.api.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.BDDMockito.then;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.apaulino.adopet.api.dto.CadastroPetDto;
import com.apaulino.adopet.api.model.Abrigo;
import com.apaulino.adopet.api.model.Pet;
import com.apaulino.adopet.api.repository.PetRepository;

@ExtendWith(MockitoExtension.class)
class PetServiceTest {

    @InjectMocks
    private PetService service;

    @Mock
    private CadastroPetDto cadastroPetDto;

    @Mock
    private PetRepository repository;

    @Mock
    private Abrigo abrigo;

    @Test
    void deveriaCadastrarPet() {
        service.cadastrarPet(abrigo, cadastroPetDto);

        then(repository).should().save(new Pet(cadastroPetDto, abrigo));
    }

    @Test
    void deveriaRetornarTodosOsPetsDisponiveis() {
        service.buscarPetsDisponiveis();

        then(repository).should().findAllByAdotadoFalse();
    }

}