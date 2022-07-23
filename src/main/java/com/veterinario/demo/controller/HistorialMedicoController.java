package com.veterinario.demo.controller;

import com.veterinario.demo.dto.HistorialMedicoRequestDto;
import com.veterinario.demo.dto.HistorialMedicoResponseDto;
import com.veterinario.demo.service.HistorialMedicoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class HistorialMedicoController {

    private final HistorialMedicoService historialMedicoService;

    @Autowired
    public HistorialMedicoController(HistorialMedicoService historialMedicoService) {
        this.historialMedicoService = historialMedicoService;
    }

    @PostMapping("/historialMedico")
    void addHistorialClinico(@Valid @RequestBody HistorialMedicoRequestDto dto){
        historialMedicoService.addHistorialMedico(dto);
    }

    @GetMapping("/historialesMedicos")
    List<HistorialMedicoResponseDto> getHistorialesMedicos(){
        return historialMedicoService.getHistorialesMedicos();
    }

    @PostMapping("/historialMedico/edit")
    void editHistorialClinico(@Valid @RequestBody HistorialMedicoRequestDto dto, @RequestParam Integer id){
        historialMedicoService.editHistorialMedico(dto, id);
    }

    @DeleteMapping("/historialMedico/inhabilitar/{id}")
    void deleteHistorialMedico(@PathVariable("id") Integer id){
        historialMedicoService.deleteHistorialMedico(id);
    }

    @GetMapping("/historialMedico/{id}")
    public HistorialMedicoResponseDto getHistorialMedicoById(@PathVariable("id") Integer id){
        return historialMedicoService.getHistorialMedicosByIdResponse(id);
    }
}
