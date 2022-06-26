package com.veterinario.demo.service;

import com.veterinario.demo.dto.TipoAnimalResponseDto;
import com.veterinario.demo.entity.TipoAnimal;
import com.veterinario.demo.repository.TipoAnimalRepository;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TipoAnimalService {

    List<TipoAnimalResponseDto> getTiposAnimales();

    TipoAnimalResponseDto getTipoAnimalById(Integer id);
}
