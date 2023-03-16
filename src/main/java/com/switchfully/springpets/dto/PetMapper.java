package com.switchfully.springpets.dto;

import com.switchfully.springpets.model.Pet;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PetMapper {
    // Pet => DTO
    public PetDTO toDTO(Pet myPet) {
        return new PetDTO(myPet.getId(), myPet.getName(), myPet.getKind(), myPet.getProfileText());
    }

    // List<Pet> => List<PetDTO>
    public List<PetDTO> toDTO(List<Pet> pets) {
        return pets.stream()
                .map(pet -> toDTO(pet))
                .toList();
    }
    // DTO => Pet
    public Pet toDomain(PetDTO petDTO) {
        return new Pet(petDTO.getId(), petDTO.getName(), petDTO.getKind(), petDTO.getProfileText());
    }
}
