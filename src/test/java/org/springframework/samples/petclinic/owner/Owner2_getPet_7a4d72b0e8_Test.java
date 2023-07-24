package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.model.Pet;
import org.springframework.samples.petclinic.model.PetType;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Owner2_getPet_7a4d72b0e8_Test {

    private Owner2 owner2;
    private List<Pet> pets;

    @BeforeEach
    void setUp() {
        this.owner2 = new Owner2();
        this.pets = new ArrayList<>();
        Pet pet1 = new Pet();
        pet1.setId(1);
        pet1.setName("Rex");
        pet1.setType(new PetType());
        this.pets.add(pet1);

        Pet pet2 = new Pet();
        pet2.setId(2);
        pet2.setName("Bella");
        pet2.setType(new PetType());
        this.pets.add(pet2);

        this.owner2.setPets(this.pets);
    }

    @Test
    void testGetPet_withExistingId() {
        Pet pet = this.owner2.getPet(1);
        assertNotNull(pet);
        assertEquals("Rex", pet.getName());
        assertEquals(new PetType(), pet.getType());
    }

    @Test
    void testGetPet_withNonExistingId() {
        Pet pet = this.owner2.getPet(3);
        assertNull(pet);
    }
}
