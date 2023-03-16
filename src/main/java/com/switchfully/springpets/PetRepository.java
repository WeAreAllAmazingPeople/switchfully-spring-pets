package com.switchfully.springpets;

import com.switchfully.springpets.model.Pet;
import com.switchfully.springpets.model.PetKind;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Repository
public class PetRepository {
    private final List<Pet> databaseOfPets = new ArrayList<>(List.of(
            new Pet(1, "Doggo", PetKind.DOG, "Woof"),
            new Pet(2, "Minous", PetKind.CAT, "Miaaauw"))
    );

    public List<Pet> getAllPets() {
        return databaseOfPets;
    }

    public Pet getPetById(int id) {
        return databaseOfPets.stream()
                .filter(pet -> pet.getId() == id)
                .findFirst()
                .orElseThrow();
    }

    public Pet save(Pet petToSave) {
        petToSave.setId(new Random().nextInt());
        databaseOfPets.add(petToSave);
        return petToSave;
    }
}
