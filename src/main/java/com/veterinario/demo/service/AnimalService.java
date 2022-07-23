package com.veterinario.demo.service;

import com.veterinario.demo.dto.AnimalRequestDto;
import com.veterinario.demo.dto.AnimalResponseDto;
import com.veterinario.demo.entity.Animal;

import java.util.List;

public interface AnimalService {

    List<AnimalResponseDto> getAnimales();

    void addAnimal(AnimalRequestDto dto);

    void editAnimal(AnimalRequestDto dto, Integer id);

    void deleteAnimal(Integer id);

    Animal getAnimalById(Integer id);

    AnimalResponseDto getAnimalByIdResponse(Integer id);
}
