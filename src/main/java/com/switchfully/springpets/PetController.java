package com.switchfully.springpets;

import com.switchfully.springpets.dto.PetDTO;
import com.switchfully.springpets.dto.PetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "pets")
public class PetController {
    private final PetService service;

    @Autowired
    public PetController(PetService service) {
        this.service = service;
    }

    @GetMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<PetDTO> getAllPets() {
        return service.getAllPets();
    }

    @GetMapping("{id}")
    public PetDTO getPetById(@PathVariable int id) {
        return service.getPetByID(id);
    }

//    @DeleteMapping("{id}")
//    public void deletePet(@PathVariable String id) {
//        service.deletePet(id);
//    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public PetDTO savePet(@RequestBody PetDTO newPet) {
        return service.savePet(newPet);
    }

}
