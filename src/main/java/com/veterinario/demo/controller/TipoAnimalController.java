package com.veterinario.demo.controller;

import com.veterinario.demo.dto.TipoAnimalResponseDto;
import com.veterinario.demo.entity.TipoAnimal;
import com.veterinario.demo.service.TipoAnimalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/tipoAnimal/{id}")
    TipoAnimalResponseDto getTipoAnimalById(@PathVariable("id") Integer id){
        return tipoAnimalService.getTipoAnimalById(id);
    }
}
