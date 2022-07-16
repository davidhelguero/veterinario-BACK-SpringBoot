package com.veterinario.demo.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class AnimalRequestDtoTest {

    AnimalRequestDto animalRequestDto = new AnimalRequestDto();

    @BeforeEach
    void setUp() {
        //animalRequestDto.setNombre("David");
        animalRequestDto.setPeso(50.1f);
        animalRequestDto.setId_tipoAnimal(1);
        animalRequestDto.setId_propietario(1);
    }

    @Test
    void setNombre() {
        //assertEquals("David",animalRequestDto.getNombre());
        assertNull(animalRequestDto.getNombre());
    }
}