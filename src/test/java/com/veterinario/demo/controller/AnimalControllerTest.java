package com.veterinario.demo.controller;

import com.veterinario.demo.dto.AnimalResponseDto;
import com.veterinario.demo.service.AnimalService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@WebMvcTest(AnimalController.class)
class AnimalControllerTest {

    @Autowired
    private MockMvc mvc;
    @Mock
    private AnimalService animalService;

    @Test
    void getAnimales() throws Exception{
        List<AnimalResponseDto> animales = new ArrayList<>();
        when(animalService.getAnimales()).thenReturn(animales);
        //ver la parte del video en la que carga la lista para después pasarla en el when
    }

    @Test
    void addAnimal() {
    }

    @Test
    void deleteAnimal() {
    }

    @Test
    void editAnimal() {
    }
}