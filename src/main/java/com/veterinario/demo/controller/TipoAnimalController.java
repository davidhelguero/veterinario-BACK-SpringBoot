package com.veterinario.demo.controller;

import com.veterinario.demo.dto.AnimalRequestDto;
import com.veterinario.demo.dto.TipoAnimalRequestDto;
import com.veterinario.demo.dto.TipoAnimalResponseDto;
import com.veterinario.demo.entity.TipoAnimal;
import com.veterinario.demo.service.TipoAnimalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class TipoAnimalController {

    private final TipoAnimalService tipoAnimalService;

    @Autowired
    public TipoAnimalController(TipoAnimalService tipoAnimalService) {
        this.tipoAnimalService = tipoAnimalService;
    }

    @GetMapping("/tiposAnimales")
    List<TipoAnimalResponseDto> getTiposAnimales(){
        return tipoAnimalService.getTiposAnimales();
    }

    @PostMapping("/tipoAnimal")
    public void addTipoAnimal(@Valid @RequestBody TipoAnimalRequestDto requestDto) throws Exception {
        tipoAnimalService.addAnimal(requestDto);
    }

    @PostMapping("/tipoAnimal/edit")
    public void editTipoAnimal(@Valid @RequestBody TipoAnimalRequestDto dto, @RequestParam Integer id){
        tipoAnimalService.editAnimal(dto, id);
    }

    @DeleteMapping("/tipoAnimal/inhabilitar/{id}")
    public void deleteTipoAnimal(@PathVariable Integer id){
        tipoAnimalService.deleteTipoAnimal(id);
    }

    @GetMapping("/tipoAnimal/{id}")
    TipoAnimalResponseDto getTipoAnimalById(@PathVariable("id") Integer id){
        return tipoAnimalService.getTipoAnimalByIdResponse(id);
    }
}
