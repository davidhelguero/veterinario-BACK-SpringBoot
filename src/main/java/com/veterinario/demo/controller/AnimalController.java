package com.veterinario.demo.controller;

import com.veterinario.demo.dto.AnimalRequestDto;
import com.veterinario.demo.dto.AnimalResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.veterinario.demo.service.AnimalService;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class AnimalController {

    private final AnimalService animalService;

    @Autowired
    public AnimalController(AnimalService animalService){
        this.animalService = animalService;
    }

    @GetMapping("/animales")
    public List<AnimalResponseDto> getAnimales() {
        return animalService.getAnimales();
    }

    @PostMapping("/animal")
    @ResponseStatus(HttpStatus.CREATED)
    public void addAnimal(@Valid @RequestBody AnimalRequestDto requestDto){
        animalService.addAnimal(requestDto);
    }

    @DeleteMapping("/animal/inhabilitar/{id}")
    public void deleteAnimal(@PathVariable("id") Integer id){animalService.deleteAnimal(id);}

    @PostMapping("/animal/edit")
    public void editAnimal(@Valid @RequestBody AnimalRequestDto requestDto, @RequestParam Integer id) {animalService.editAnimal(requestDto, id);}

    @GetMapping("/animal/{id}")
    public AnimalResponseDto getAnimalById(@PathVariable("id") Integer id){
        return animalService.getAnimalByIdResponse(id);
    }
}
