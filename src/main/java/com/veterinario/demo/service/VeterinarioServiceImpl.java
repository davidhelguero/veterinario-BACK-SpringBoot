package com.veterinario.demo.service;

import com.veterinario.demo.dto.VeterinarioRequestDto;
import com.veterinario.demo.dto.VeterinarioResponseDto;
import com.veterinario.demo.entity.Veterinario;
import com.veterinario.demo.repository.VeterinarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VeterinarioServiceImpl implements VeterinarioService{

    private final VeterinarioRepository veterinarioRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public VeterinarioServiceImpl(VeterinarioRepository veterinarioRepository, ModelMapper modelMapper){
        this.veterinarioRepository = veterinarioRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<VeterinarioResponseDto> getVeterinarios() {

        List<Veterinario> veterinarios = veterinarioRepository.findAll();
        List<Veterinario> veterinariosActivos = new ArrayList<>();

        for(Veterinario vet : veterinarios){
            if(vet.isEstado())
                veterinariosActivos.add(vet);
        }

        return veterinariosActivos.stream().parallel()
                .map(veterinario -> modelMapper.map(veterinario, VeterinarioResponseDto.class))
                .collect(Collectors.toList());

    }

    @Override
    public void addVeterinario(VeterinarioRequestDto dto) {

        Veterinario veterinario = modelMapper.map(dto, Veterinario.class);
        veterinario.setEstado(true);
        veterinarioRepository.save(veterinario);
    }

    @Override
    public void editVeterinario(VeterinarioRequestDto dto, Integer id) {

        Veterinario veterinario = getVeterinarioById(id);
        Veterinario actualizado = modelMapper.map(dto, Veterinario.class);
        actualizado.setId(veterinario.getId());
        actualizado.setEstado(true);
        veterinarioRepository.save(actualizado);
    }

    @Override
    public void deleteVeterinario(Integer id) {

        Veterinario veterinario = getVeterinarioById(id);
        veterinario.setEstado(false);
        veterinarioRepository.save(veterinario);
    }

    @Override
    public Veterinario getVeterinarioById(Integer id){

        Optional<Veterinario> veterinario = veterinarioRepository.findById(id);
        if(!veterinario.isPresent())
            throw new NullPointerException("El veterinario no existe");
        return veterinario.get();
    }

    @Override
    public VeterinarioResponseDto getVeterinarioByIdResponse(Integer id) {
        Veterinario veterinario = getVeterinarioById(id);
        return modelMapper.map(veterinario, VeterinarioResponseDto.class);
    }
}
