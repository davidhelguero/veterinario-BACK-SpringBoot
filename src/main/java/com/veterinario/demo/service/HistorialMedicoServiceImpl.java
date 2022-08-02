package com.veterinario.demo.service;

import com.veterinario.demo.dto.AnimalResponseDto;
import com.veterinario.demo.dto.HistorialMedicoRequestDto;
import com.veterinario.demo.dto.HistorialMedicoResponseDto;
import com.veterinario.demo.entity.Animal;
import com.veterinario.demo.entity.HistorialMedico;
import com.veterinario.demo.entity.Veterinario;
import com.veterinario.demo.repository.HistorialMedicoRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HistorialMedicoServiceImpl implements HistorialMedicoService{
    //@Autowired
    private final ModelMapper modelMapper;
    //@Autowired
    private final HistorialMedicoRepository historialMedicoRepository;
    //@Autowired
    private final VeterinarioService veterinarioService;
    //@Autowired
    private final AnimalService animalService;

    //public HistorialMedicoServiceImpl(){}

    @Autowired
    public HistorialMedicoServiceImpl(ModelMapper modelMapper, HistorialMedicoRepository historialMedicoRepository, VeterinarioService veterinarioService, AnimalService animalService) {
        this.modelMapper = modelMapper;
        this.historialMedicoRepository = historialMedicoRepository;
        this.veterinarioService = veterinarioService;
        this.animalService = animalService;
    }

    @Override
    public void addHistorialMedico(HistorialMedicoRequestDto dto) {

        HistorialMedico historialMedico= modelMapper.map(dto, HistorialMedico.class);

        historialMedico.setFecha(LocalDate.now());
        historialMedico.setEstado(true);
        Animal animal = animalService.getAnimalById(dto.getId_animal());
        historialMedico.setAnimal(animal);
        Veterinario veterinario = veterinarioService.getVeterinarioById(dto.getId_veterinario());
        historialMedico.setVeterinario(veterinario);

        historialMedicoRepository.save(historialMedico);
    }

    @Override
    public List<HistorialMedicoResponseDto> getHistorialesMedicos() {
        List<HistorialMedico> historialesMedicos = historialMedicoRepository.findHistorialMedicoByEstado(true);

        return historialesMedicos.stream().parallel()
                .map(historialMedico -> modelMapper.map(historialMedico, HistorialMedicoResponseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void editHistorialMedico(HistorialMedicoRequestDto dto, Integer id) {

        HistorialMedico historialMedico = getHistorialMedicoById(id);

        historialMedico.setDescripcion(dto.getDescripcion());
        Animal animal = animalService.getAnimalById(dto.getId_animal());
        historialMedico.setAnimal(animal);
        Veterinario veterinario = veterinarioService.getVeterinarioById(dto.getId_veterinario());
        historialMedico.setVeterinario(veterinario);

        historialMedicoRepository.save(historialMedico);
    }

    @Override
    public void deleteHistorialMedico(Integer id) {
        HistorialMedico historialMedico = getHistorialMedicoById(id);
        historialMedico.setEstado(false);
        historialMedicoRepository.save(historialMedico);
    }

    @Override
    public HistorialMedicoResponseDto getHistorialMedicosByIdResponse(Integer id) {
        HistorialMedico historialMedico = getHistorialMedicoById(id);
        return modelMapper.map(historialMedico, HistorialMedicoResponseDto.class);
    }

    public HistorialMedico getHistorialMedicoById(Integer id){
        Optional<HistorialMedico> historialMedico = historialMedicoRepository.findById(id);
        if(!historialMedico.isPresent())
            throw new NullPointerException("El historial médico no existe");
        return historialMedico.get();
    }
}
