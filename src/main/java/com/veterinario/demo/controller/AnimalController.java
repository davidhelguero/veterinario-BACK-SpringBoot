package com.veterinario.demo.controller;

import com.veterinario.demo.dto.AnimalRequestDto;
import com.veterinario.demo.dto.AnimalResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.veterinario.demo.service.AnimalService;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
    public void addAnimal(@Valid @RequestBody AnimalRequestDto requestDto,
                            @RequestParam("file") MultipartFile imagen){
        if(!imagen.isEmpty()){
            Path directorioImagen = Paths.get("src//main//resources//static/images");
            String rutaAbsoluta = directorioImagen.toFile().getAbsolutePath();
            try {
                byte[] bytesImg = imagen.getBytes();
                Path rutaCompleta = Paths.get(rutaAbsoluta + "//" + imagen.getOriginalFilename());
                Files.write(rutaCompleta, bytesImg);
                //animal.setImagen(imagen.getOriginalFilename());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        animalService.addAnimal(requestDto);
    }

    @DeleteMapping("/{id}")
    public void deleteAnimal(@PathVariable("id") Integer id){animalService.deleteAnimal(id);}

    @PostMapping("/animal/edit")
    public void editAnimal(@Valid @RequestBody AnimalRequestDto requestDto, @RequestParam Integer id) {animalService.editAnimal(requestDto, id);}
}
