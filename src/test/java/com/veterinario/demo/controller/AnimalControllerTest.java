package com.veterinario.demo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.veterinario.demo.constants.EstadoAnimal;
import com.veterinario.demo.dto.AnimalRequestDto;
import com.veterinario.demo.dto.AnimalResponseDto;
import com.veterinario.demo.entity.Propietario;
import com.veterinario.demo.entity.TipoAnimal;
import com.veterinario.demo.service.AnimalService;
import com.veterinario.demo.service.PropietarioService;
import com.veterinario.demo.service.TipoAnimalService;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AnimalController.class)
class AnimalControllerTest {

    @Autowired
    private MockMvc mvc;
    @MockBean
    private AnimalService animalService;
    @MockBean
    private TipoAnimalService tipoAnimalService;
    @MockBean
    private PropietarioService propietarioService;
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp(){
        objectMapper = new ObjectMapper();
    }
    @Test
    void getAnimales() throws Exception{
        List<AnimalResponseDto> animales = getAnimalesMock();
        when(animalService.getAnimales()).thenReturn(animales);

        mvc.perform(get("/api/v1/animales").contentType(MediaType.APPLICATION_JSON))
           .andExpect(status().isOk())
           .andExpect(content().contentType(MediaType.APPLICATION_JSON));

        verify(animalService).getAnimales();
    }

    @Test
    void addAnimal() throws Exception {
        AnimalRequestDto animal = new AnimalRequestDto("Apolo", 15.5f, 1, 1);

        mvc.perform(post("/api/v1/animal").contentType(MediaType.APPLICATION_JSON)
           .content(objectMapper.writeValueAsString(animal)))
           .andExpect(status().isCreated());

        verify(animalService).addAnimal(animal);
    }

    @Test
    void addAnimalNombreVacio() throws Exception {
        AnimalRequestDto animal = new AnimalRequestDto("", 15.5f, 1, 1);

        mvc.perform(post("/api/v1/animal")
           .contentType(MediaType.APPLICATION_JSON)
           .content(objectMapper.writeValueAsString(animal)))
           .andExpect(status().isBadRequest());

    }

    @Test
    void addAnimalPesoMenorAUno() throws Exception {
        AnimalRequestDto animal = new AnimalRequestDto("Apolo", 0, 1, 1);

        mvc.perform(post("/api/v1/animal")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(animal)))
                .andExpect(status().isBadRequest());

    }

    @Test
    void addAnimalVacio() throws Exception {
        AnimalRequestDto animal = new AnimalRequestDto();

        mvc.perform(post("/api/v1/animal")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(animal)))
                .andExpect(status().isBadRequest());

    }

    @Test
    void deleteAnimal() throws Exception{
        mvc.perform(delete("/api/v1/animal/inhabilitar/{id}",1))
           .andExpect(status().isOk());

        verify(animalService).deleteAnimal(1);
    }

    @Test
    void editAnimal() throws Exception{
        AnimalRequestDto animal = new AnimalRequestDto("Chiquita", 5, 1, 1);

        mvc.perform(post("/api/v1/animal/edit?id=1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(animal)))
                .andExpect(status().isOk());

        verify(animalService).editAnimal(animal,1);
    }

    private List<AnimalResponseDto> getAnimalesMock() {
        List<AnimalResponseDto> animales = new ArrayList<>();
        TipoAnimal tipo = new TipoAnimal(1,"Perro",true);
        Propietario propietario = new Propietario(1,"David","Helguero","38630120",true,"dahelguero@gmail.com","1122223333");
        animales.add(new AnimalResponseDto(1,"Apolo",15.5f, LocalDate.now(), EstadoAnimal.ACTIVO, tipo, propietario));
        return animales;
    }

}