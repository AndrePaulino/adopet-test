package com.apaulino.adopet.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apaulino.adopet.api.dto.AtualizacaoTutorDto;
import com.apaulino.adopet.api.dto.CadastroTutorDto;
import com.apaulino.adopet.api.exception.ValidacaoException;
import com.apaulino.adopet.api.model.Tutor;
import com.apaulino.adopet.api.repository.TutorRepository;

@Service
public class TutorService {

    @Autowired
    private TutorRepository repository;

    public void cadastrar(CadastroTutorDto dto) {
        boolean jaCadastrado = repository.existsByTelefoneOrEmail(dto.telefone(), dto.email());

        if (jaCadastrado)
            throw new ValidacaoException("Dados já cadastrados para outro tutor!");

        repository.save(new Tutor(dto));
    }

    public void atualizar(AtualizacaoTutorDto dto) {
        Tutor tutor = repository.getReferenceById(dto.id());
        tutor.atualizarDados(dto);
    }

}
