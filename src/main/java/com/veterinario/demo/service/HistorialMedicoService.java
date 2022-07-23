package com.veterinario.demo.service;

import com.veterinario.demo.dto.HistorialMedicoRequestDto;
import com.veterinario.demo.dto.HistorialMedicoResponseDto;

import java.util.List;

public interface HistorialMedicoService {

    void addHistorialMedico(HistorialMedicoRequestDto dto);

    List<HistorialMedicoResponseDto> getHistorialesMedicos();

    void editHistorialMedico(HistorialMedicoRequestDto dto, Integer id);

    void deleteHistorialMedico(Integer id);

    HistorialMedicoResponseDto getHistorialMedicosByIdResponse(Integer id);
}
