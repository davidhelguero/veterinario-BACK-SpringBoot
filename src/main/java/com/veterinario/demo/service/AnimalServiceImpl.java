package com.veterinario.demo.service;

import com.veterinario.demo.constants.EstadoAnimal;
import com.veterinario.demo.dto.AnimalRequestDto;
import com.veterinario.demo.dto.AnimalResponseDto;
import com.veterinario.demo.entity.Animal;
import com.veterinario.demo.entity.Propietario;
import com.veterinario.demo.entity.TipoAnimal;
import com.veterinario.demo.repository.AnimalRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AnimalServiceImpl implements AnimalService{
    //@Autowired
    private final AnimalRepository animalRepository;
    //@Autowired
    private final ModelMapper modelMapper;
    //@Autowired
    private final TipoAnimalService tipoAnimalService;
    //@Autowired
    private final PropietarioService propietarioService;

    //public AnimalServiceImpl(){};

    @Autowired
    public AnimalServiceImpl(AnimalRepository animalRepository, ModelMapper modelMapper, TipoAnimalService tipoAnimalService, PropietarioService propietarioService){
        this.animalRepository = animalRepository;
        this.modelMapper = modelMapper;
        this.tipoAnimalService = tipoAnimalService;
        this.propietarioService = propietarioService;
    }

    @Override
    public List<AnimalResponseDto> getAnimales() {
        List<Animal> listAnimales = animalRepository.findAnimalByEstado(EstadoAnimal.ACTIVO);

        return listAnimales.stream().parallel()
                .map(animal -> modelMapper.map(animal, AnimalResponseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void addAnimal(AnimalRequestDto dto) {

        Animal animal = modelMapper.map(dto, Animal.class);

        animal.setFechaCreacion(LocalDate.now());
        animal.setEstado(EstadoAnimal.ACTIVO);
        TipoAnimal tipoAnimal = tipoAnimalService.getTipoAnimalById(dto.getId_tipoAnimal());
        animal.setTipo(tipoAnimal);
        Propietario propietario = propietarioService.getPropietarioById(dto.getId_propietario());
        animal.setPropietario(propietario);

        animalRepository.save(animal);
    }

    @Override
    public void deleteAnimal(Integer id) {
        Animal animal = getAnimalById(id);
        animal.setEstado(EstadoAnimal.INACTIVO);
        animalRepository.save(animal);
    }

    @Override
    public void editAnimal(AnimalRequestDto dto, Integer id){
        Animal animal = getAnimalById(id);
        animal.setNombre(dto.getNombre());
        animal.setPeso(dto.getPeso());
        TipoAnimal tipoAnimal = tipoAnimalService.getTipoAnimalById(dto.getId_tipoAnimal());
        animal.setTipo(tipoAnimal);
        Propietario propietario = propietarioService.getPropietarioById(dto.getId_propietario());
        animal.setPropietario(propietario);
        animalRepository.save(animal);
    }

    @Override
    public Animal getAnimalById(Integer id){
        Optional<Animal> animal = animalRepository.findById(id);
        if(!animal.isPresent())
            throw new NullPointerException("El animal no existe");
        return animal.get();
    }

    @Override
    public AnimalResponseDto getAnimalByIdResponse(Integer id) {
        Animal animal = getAnimalById(id);
        return modelMapper.map(animal, AnimalResponseDto.class);
    }
}
