package org.springframework.samples.petclinic.owner;

import org.springframework.samples.petclinic.model.Pet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Owner_addPet_8df3885a5e_Test {
    private Owner owner;
    private Pet pet1;
    private Pet pet2;

    @BeforeEach
    void setUp() {
        owner = new Owner();
        pet1 = new Pet();
        pet2 = new Pet();
        pet2.setId(2);
    }

    @Test
    void testAddPetWhenPetIsNew() {
        owner.addPet(pet1);
        assertTrue(owner.getPets().contains(pet1));
    }

    @Test
    void testAddPetWhenPetIsNotNew() {
        owner.addPet(pet2);
        assertFalse(owner.getPets().contains(pet2));
    }
}
