package com.apaulino.adopet.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apaulino.adopet.api.dto.CadastroPetDto;
import com.apaulino.adopet.api.dto.PetDto;
import com.apaulino.adopet.api.model.Abrigo;
import com.apaulino.adopet.api.model.Pet;
import com.apaulino.adopet.api.repository.PetRepository;

@Service
public class PetService {

    @Autowired
    private PetRepository repository;

    public List<PetDto> buscarPetsDisponiveis() {
        return repository
                .findAllByAdotadoFalse()
                .stream()
                .map(PetDto::new)
                .toList();
    }

    public void cadastrarPet(Abrigo abrigo, CadastroPetDto dto) {
        repository.save(new Pet(dto, abrigo));
    }
}
