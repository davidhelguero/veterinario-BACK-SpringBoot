package com.veterinario.demo.service;

import com.veterinario.demo.dto.AnimalRequestDto;
import com.veterinario.demo.dto.AnimalResponseDto;

import java.util.List;

public interface AnimalService {

    List<AnimalResponseDto> getAnimales();

    void addAnimal(AnimalRequestDto dto);

    void deleteAnimal(Integer id);

    void editAnimal(AnimalRequestDto dto, Integer id);
}
