package com.switchfully.springpets.dto;

import com.switchfully.springpets.model.PetKind;

public class PetDTO {
    private final int id;
    private final String name;
    private final PetKind kind;
    private final String profileText;

    public PetDTO(int id, String name, PetKind kind, String profileText) {
        this.id = id;
        this.name = name;
        this.kind = kind;
        this.profileText = profileText;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public PetKind getKind() {
        return kind;
    }

    public String getProfileText() {
        return profileText;
    }
}
