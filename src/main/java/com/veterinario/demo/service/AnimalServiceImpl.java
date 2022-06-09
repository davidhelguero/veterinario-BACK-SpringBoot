package com.veterinario.demo.service;

import com.veterinario.demo.constants.EstadoAnimal;
import com.veterinario.demo.dto.AnimalRequestDto;
import com.veterinario.demo.dto.AnimalResponseDto;
import com.veterinario.demo.entity.Animal;
import com.veterinario.demo.repository.AnimalRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnimalServiceImpl implements AnimalService{

    private final AnimalRepository animalRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public AnimalServiceImpl(AnimalRepository animalRepository, ModelMapper modelMapper){
        this.animalRepository = animalRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<AnimalResponseDto> getAnimales() {
        List<Animal> listAnimales = animalRepository.findAll();

        return listAnimales.stream().parallel()
                .map(animal -> modelMapper.map(animal, AnimalResponseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void addAnimal(AnimalRequestDto dto) {
        Animal animal = modelMapper.map(dto, Animal.class);
        animal.setFechaCreacion(LocalDate.now());
        animal.setEstado(EstadoAnimal.ACTIVO);

        animalRepository.save(animal);
    }
}
