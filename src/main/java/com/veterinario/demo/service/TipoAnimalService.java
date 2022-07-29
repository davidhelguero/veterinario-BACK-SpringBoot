package com.veterinario.demo.service;

import com.veterinario.demo.dto.TipoAnimalRequestDto;
import com.veterinario.demo.dto.TipoAnimalResponseDto;
import com.veterinario.demo.entity.TipoAnimal;
import com.veterinario.demo.repository.TipoAnimalRepository;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TipoAnimalService {

    void addAnimal(TipoAnimalRequestDto dto) throws Exception;

    List<TipoAnimalResponseDto> getTiposAnimales();

    TipoAnimal getTipoAnimalById(Integer id);

    TipoAnimalResponseDto getTipoAnimalByIdResponse(Integer id);

    void editAnimal(TipoAnimalRequestDto dto, Integer id);

    void deleteTipoAnimal(Integer id);
}
