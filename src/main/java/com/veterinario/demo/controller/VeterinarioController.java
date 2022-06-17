package com.veterinario.demo.controller;

import com.veterinario.demo.dto.VeterinarioRequestDto;
import com.veterinario.demo.dto.VeterinarioResponseDto;
import com.veterinario.demo.service.VeterinarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class VeterinarioController {

    private final VeterinarioService veterinarioService;

    @Autowired
    public VeterinarioController(VeterinarioService veterinarioService) {
        this.veterinarioService = veterinarioService;
    }

    @GetMapping("/veterinarios")
    public List<VeterinarioResponseDto> getVeterinarios(){
        return veterinarioService.getVeterinarios();
    }

    @PostMapping("/veterinario")
    public void addVeterinario(@Valid @RequestBody VeterinarioRequestDto dto){
        veterinarioService.addVeterinario(dto);
    }

    @PostMapping("/veterinario/edit")
    public void editVeterinario(@Valid @RequestBody VeterinarioRequestDto dto, @RequestParam Integer id){
        veterinarioService.editVeterinario(dto, id);
    }

    @DeleteMapping("/veterinario/inhabilitar/{id}")
    public void deleteVeterinario(@PathVariable("id") Integer id){
        veterinarioService.deleteVeterinario(id);
    }




}
