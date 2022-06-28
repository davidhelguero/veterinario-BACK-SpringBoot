package com.veterinario.demo.service;

import com.veterinario.demo.dto.PropietarioRequestDto;
import com.veterinario.demo.dto.PropietarioResponseDto;
import com.veterinario.demo.entity.Propietario;
import com.veterinario.demo.repository.PropietarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PropietarioServiceImpl implements PropietarioService{

    private final PropietarioRepository propietarioRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public PropietarioServiceImpl(PropietarioRepository propietarioRepository, ModelMapper modelMapper){
        this.propietarioRepository = propietarioRepository;
        this.modelMapper  = modelMapper;
    }

    @Override
    public List<PropietarioResponseDto> getPropietarios() {

        List<Propietario> propietarios = propietarioRepository.findAll();
        List<Propietario> propietariosActivos = new ArrayList<>();

        for (Propietario prop: propietarios) {
            if(prop.isEstado())
                propietariosActivos.add(prop);
        }

        return propietariosActivos.stream().parallel()
                .map(propietario -> modelMapper.map(propietario, PropietarioResponseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void addPropietario(PropietarioRequestDto dto) {

        Propietario propietario = modelMapper.map(dto, Propietario.class);
        propietario.setEstado(true);
        propietarioRepository.save(propietario);
    }

    @Override
    public void editPropietario(PropietarioRequestDto dto, Integer id) {

        Propietario propietario = getPropietarioById(id);
        Propietario actualizado = modelMapper.map(dto, Propietario.class);
        actualizado.setId(propietario.getId());
        actualizado.setEstado(true);
        propietarioRepository.save(actualizado);
    }

    @Override
    public void deletePropietario(Integer id) {

        Propietario propietario = getPropietarioById(id);
        propietario.setEstado(false);
        propietarioRepository.save(propietario);
    }
    @Override
    public Propietario getPropietarioById(Integer id){

        Optional<Propietario> propietario = propietarioRepository.findById(id);
        if(!propietario.isPresent())
            throw new NullPointerException("El propietario no existe");
        return propietario.get();
    }

    @Override
    public PropietarioResponseDto getPropietarioByIdResponse(Integer id) {
        Propietario propietario = getPropietarioById(id);
        return modelMapper.map(propietario, PropietarioResponseDto.class);
    }
}
