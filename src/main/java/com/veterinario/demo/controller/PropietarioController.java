package com.veterinario.demo.controller;

import com.veterinario.demo.dto.PropietarioRequestDto;
import com.veterinario.demo.dto.PropietarioResponseDto;
import com.veterinario.demo.service.PropietarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class PropietarioController {

    private final PropietarioService propietarioService;

    @Autowired
    public PropietarioController(PropietarioService propietarioService) {
        this.propietarioService = propietarioService;
    }

    @GetMapping("/propietarios")
    public List<PropietarioResponseDto> getPropietarios(){
        return propietarioService.getPropietarios();
    }

    @PostMapping("/propietario")
    public void addPropietario(@Valid @RequestBody PropietarioRequestDto dto){
        propietarioService.addPropietario(dto);
    }

    @PostMapping("/propietario/edit")
    public void editPropietario(@Valid @RequestBody PropietarioRequestDto dto,@RequestParam Integer id){
        propietarioService.editPropietario(dto, id);
    }

    @DeleteMapping("/propietario/inhabilitar/{id}")
    public void editPropietario(@PathVariable("id") Integer id){
        propietarioService.deletePropietario(id);
    }
}
