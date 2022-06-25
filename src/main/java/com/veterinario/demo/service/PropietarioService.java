package com.veterinario.demo.service;

import com.veterinario.demo.dto.PropietarioRequestDto;
import com.veterinario.demo.dto.PropietarioResponseDto;
import com.veterinario.demo.entity.Propietario;

import java.util.List;

public interface PropietarioService {

    List<PropietarioResponseDto> getPropietarios();

    void addPropietario(PropietarioRequestDto dto);

    void editPropietario(PropietarioRequestDto dto, Integer id);

    void deletePropietario(Integer id);

    Propietario getPropietarioById(Integer id);

    PropietarioResponseDto getPropietarioByIdResponse(Integer id);

}
