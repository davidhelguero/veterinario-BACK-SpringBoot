package com.veterinario.demo.service;

import com.veterinario.demo.dto.TipoAnimalRequestDto;
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
    public void addAnimal(TipoAnimalRequestDto dto) throws Exception {
        TipoAnimal tipoAnimal = modelMapper.map(dto, TipoAnimal.class);
        tipoAnimal.setEstado(true);

        if(tipoAnimalRepository.existsByDescripcion(dto.getDescripcion()))
            throw new Exception("El tipo de animal ya existe");
        tipoAnimalRepository.save(tipoAnimal);
    }

    @Override
    public List<TipoAnimalResponseDto> getTiposAnimales() {
        List<TipoAnimal> listTiposAnimales = tipoAnimalRepository.findTipoAnimalByEstado(true);

        return listTiposAnimales.stream().parallel()
                .map(tipoAnimal -> modelMapper.map(tipoAnimal, TipoAnimalResponseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public TipoAnimal getTipoAnimalById(Integer id) {
        Optional<TipoAnimal> tipoAnimal = tipoAnimalRepository.findById(id);
        if(!tipoAnimal.isPresent())
            throw new NullPointerException("El tipo de animal no existe");
        return tipoAnimal.get();
    }

    @Override
    public TipoAnimalResponseDto getTipoAnimalByIdResponse(Integer id) {
        Optional<TipoAnimal> tipoAnimal = tipoAnimalRepository.findById(id);
        if(!tipoAnimal.isPresent())
            throw new NullPointerException("El tipo de animal no existe");
        return modelMapper.map(tipoAnimal.get(),TipoAnimalResponseDto.class);
    }

    @Override
    public void editAnimal(TipoAnimalRequestDto dto, Integer id) {
        TipoAnimal tipoAnimal = getTipoAnimalById(id);
        tipoAnimal.setDescripcion(dto.getDescripcion());
        tipoAnimalRepository.save(tipoAnimal);
    }

    @Override
    public void deleteTipoAnimal(Integer id) {
        TipoAnimal tipoAnimal = getTipoAnimalById(id);
        tipoAnimal.setEstado(false);
        tipoAnimalRepository.save(tipoAnimal);
    }

}
