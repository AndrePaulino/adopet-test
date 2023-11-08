package com.apaulino.adopet.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apaulino.adopet.api.model.Adocao;
import com.apaulino.adopet.api.model.StatusAdocao;

public interface AdocaoRepository extends JpaRepository<Adocao, Long> {

    boolean existsByPetIdAndStatus(Long idPet, StatusAdocao status);

}
