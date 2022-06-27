package com.veterinario.demo.service;

import com.veterinario.demo.dto.TipoAnimalResponseDto;
import com.veterinario.demo.entity.TipoAnimal;
import com.veterinario.demo.repository.TipoAnimalRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TipoAnimalServiceImpl implements TipoAnimalService{

    private final TipoAnimalRepository tipoAnimalRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public TipoAnimalServiceImpl(TipoAnimalRepository tipoAnimalRepository, ModelMapper modelMapper) {
        this.tipoAnimalRepository = tipoAnimalRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<TipoAnimalResponseDto> getTiposAnimales() {
        List<TipoAnimal> listTiposAnimales = tipoAnimalRepository.findAll();

        return listTiposAnimales.stream().parallel()
                .map(tipoAnimal -> modelMapper.map(tipoAnimal, TipoAnimalResponseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public TipoAnimal getTipoAnimalById(Integer id) {
        Optional<TipoAnimal> tipoAnimal = tipoAnimalRepository.findById(id);
        if(!tipoAnimal.isPresent())
            throw new NullPointerException("No existe");
        return tipoAnimal.get();
    }

    @Override
    public TipoAnimalResponseDto getTipoAnimalByIdResponse(Integer id) {
        Optional<TipoAnimal> tipoAnimal = tipoAnimalRepository.findById(id);
        if(!tipoAnimal.isPresent())
            throw new NullPointerException("No existe");
        return modelMapper.map(tipoAnimal.get(),TipoAnimalResponseDto.class);
    }
}
