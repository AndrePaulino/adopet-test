package com.apaulino.adopet.api.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.jupiter.api.Test;

import com.apaulino.adopet.api.dto.CadastroAbrigoDto;
import com.apaulino.adopet.api.dto.CadastroPetDto;
import com.apaulino.adopet.api.model.Abrigo;
import com.apaulino.adopet.api.model.Pet;
import com.apaulino.adopet.api.model.ProbabilidadeAdocao;
import com.apaulino.adopet.api.model.TipoPet;

public class CalculadoraProbabilidadeAdocaoTest {

    @Test
    void gatoDe4Anos4KgDeveRetornarProbabilidadeAlta() {
        Abrigo abrigo = new Abrigo(new CadastroAbrigoDto(
                "Abrigo feliz",
                "94999999999",
                "abrigofeliz@email.com.br"));
        Pet pet = new Pet(new CadastroPetDto(
                TipoPet.GATO,
                "Miau",
                "Siames",
                4,
                "Cinza",
                4.0f), abrigo);

        CalculadoraProbabilidadeAdocao calculadora = new CalculadoraProbabilidadeAdocao();
        ProbabilidadeAdocao probabilidade = calculadora.calcular(pet);

        assertThat(probabilidade, equalTo(ProbabilidadeAdocao.ALTA));
    }

    @Test
    void gatoDe15Anos4KgDeveRetornarProbabilidadeMedia() {
        Abrigo abrigo = new Abrigo(new CadastroAbrigoDto(
                "Abrigo feliz",
                "94999999999",
                "abrigofeliz@email.com.br"));
        Pet pet = new Pet(new CadastroPetDto(
                TipoPet.GATO,
                "Miau",
                "Siames",
                15,
                "Cinza",
                4.0f), abrigo);

        CalculadoraProbabilidadeAdocao calculadora = new CalculadoraProbabilidadeAdocao();
        ProbabilidadeAdocao probabilidade = calculadora.calcular(pet);

        assertThat(probabilidade, equalTo(ProbabilidadeAdocao.MEDIA));
    }
}
