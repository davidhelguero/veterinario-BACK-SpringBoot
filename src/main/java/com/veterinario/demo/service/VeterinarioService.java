package com.veterinario.demo.service;

import com.veterinario.demo.dto.VeterinarioRequestDto;
import com.veterinario.demo.dto.VeterinarioResponseDto;
import com.veterinario.demo.entity.Veterinario;

import java.util.List;

public interface VeterinarioService {

    List<VeterinarioResponseDto> getVeterinarios();

    void addVeterinario(VeterinarioRequestDto dto);

    void editVeterinario(VeterinarioRequestDto dto, Integer id);

    void deleteVeterinario(Integer id);

    Veterinario getVeterinarioById(Integer id);

    VeterinarioResponseDto getVeterinarioByIdResponse(Integer id);
}
