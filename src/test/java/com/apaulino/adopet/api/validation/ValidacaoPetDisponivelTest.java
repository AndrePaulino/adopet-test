package com.apaulino.adopet.api.validation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.apaulino.adopet.api.dto.SolicitacaoAdocaoDto;
import com.apaulino.adopet.api.exception.ValidacaoException;
import com.apaulino.adopet.api.model.Pet;
import com.apaulino.adopet.api.repository.PetRepository;

@ExtendWith(MockitoExtension.class)
class ValidacaoPetDisponivelTest {

    @InjectMocks
    private ValidacaoPetDisponivel validacao;

    @Mock
    private PetRepository petRepository;
    @Mock
    private Pet pet;
    @Mock
    private SolicitacaoAdocaoDto dto;

    @Test
    void deveriaPermitirSolicitacaoDeAdocaoPet() {
        BDDMockito.given(petRepository.getReferenceById(dto.idPet())).willReturn(pet);
        BDDMockito.given(pet.getAdotado()).willReturn(false);

        Assertions.assertDoesNotThrow(() -> validacao.validar(dto));
    }

    @Test
    void naoDeveriaPermitirSolicitacaoDeAdocaoPet() {
        BDDMockito.given(petRepository.getReferenceById(dto.idPet())).willReturn(pet);
        BDDMockito.given(pet.getAdotado()).willReturn(true);

        Assertions.assertThrows(ValidacaoException.class, () -> validacao.validar(dto));
    }

}