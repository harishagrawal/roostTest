package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.model.Pet;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class Owner_getPet_a2da54c166_Test {

    private Owner owner;
    private Set<Pet> pets;
    private Pet pet1;
    private Pet pet2;

    @BeforeEach
    void setUp() {
        owner = new Owner();
        pets = new HashSet<>();
        pet1 = new Pet();
        pet1.setName("Bobby");
        pet2 = new Pet();
        pet2.setName("Tommy");
        pets.add(pet1);
        pets.add(pet2);
        owner.setPetsInternal(pets);
    }

    @Test
    void testGetPetSuccess() {
        Pet pet = owner.getPet("Bobby", true);
        assertNotNull(pet);
        assertEquals("Bobby", pet.getName());
    }

    @Test
    void testGetPetNotFound() {
        Pet pet = owner.getPet("Max", true);
        assertNull(pet);
    }

    @Test
    void testGetPetIgnoreNew() {
        pet1.setNew(true);
        Pet pet = owner.getPet("Bobby", true);
        assertNull(pet);
    }

    @Test
    void testGetPetNotIgnoreNew() {
        pet1.setNew(true);
        Pet pet = owner.getPet("Bobby", false);
        assertNotNull(pet);
        assertEquals("Bobby", pet.getName());
    }
}
