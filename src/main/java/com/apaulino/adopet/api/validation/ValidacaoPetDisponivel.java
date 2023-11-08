package com.apaulino.adopet.api.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.apaulino.adopet.api.dto.SolicitacaoAdocaoDto;
import com.apaulino.adopet.api.exception.ValidacaoException;
import com.apaulino.adopet.api.model.Pet;
import com.apaulino.adopet.api.repository.PetRepository;

@Component
public class ValidacaoPetDisponivel implements ValidacaoSolicitacaoAdocao {

    @Autowired
    private PetRepository petRepository;

    @Override
    public void validar(SolicitacaoAdocaoDto dto) {
        Pet pet = petRepository.getReferenceById(dto.idPet());
        if (pet.getAdotado()) {
            throw new ValidacaoException("Pet já foi adotado!");
        }
    }

}
