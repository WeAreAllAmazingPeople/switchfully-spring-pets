package com.switchfully.springpets;

import com.switchfully.springpets.dto.PetDTO;
import com.switchfully.springpets.dto.PetMapper;
import com.switchfully.springpets.model.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {
    private final PetRepository repository;
    private final PetMapper mapper;

    @Autowired
    public PetService(PetRepository repository, PetMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<PetDTO> getAllPets() {
        return mapper.toDTO(repository.getAllPets());
    }

    public PetDTO getPetByID(int id) {
        return mapper.toDTO(repository.getPetById(id));
    }

    public PetDTO savePet(PetDTO newPet) {
        assertValidPetDTO(newPet);
        Pet petToSave = mapper.toDomain(newPet);
        return mapper.toDTO(repository.save(petToSave));
    }

    private static void assertValidPetDTO(PetDTO newPet) {
        if(newPet.getName() == null || newPet.getKind() == null) {
            throw new IllegalArgumentException();
        }
    }
}
