package com.apaulino.adopet.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apaulino.adopet.api.dto.PetDto;
import com.apaulino.adopet.api.service.PetService;

@RestController
@RequestMapping("/pets")
public class PetController {

    @Autowired
    private PetService service;

    @GetMapping
    public ResponseEntity<List<PetDto>> listarTodosDisponiveis() {
        List<PetDto> pets = service.buscarPetsDisponiveis();
        return ResponseEntity.ok(pets);
    }

}
