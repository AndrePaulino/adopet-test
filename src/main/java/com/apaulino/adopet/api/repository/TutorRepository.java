package com.apaulino.adopet.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apaulino.adopet.api.model.Tutor;

public interface TutorRepository extends JpaRepository<Tutor, Long> {

    boolean existsByTelefoneOrEmail(String telefone, String email);

}
