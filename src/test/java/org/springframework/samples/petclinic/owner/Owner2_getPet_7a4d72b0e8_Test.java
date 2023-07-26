package org.springframework.samples.petclinic.owner;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.model.Pet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class Owner2_getPet_7a4d72b0e8_Test {

    private Owner owner;

    @BeforeEach
    public void setup() {
        owner = new Owner();
        Pet pet1 = new Pet();
        pet1.setId(1);
        pet1.setName("Pet1");
        Pet pet2 = new Pet();
        pet2.setId(2);
        pet2.setName("Pet2");
        Set<Pet> pets = new HashSet<>(Arrays.asList(pet1, pet2));
        owner.setPetsInternal(pets);
    }

    @Test
    public void testGetPet_success() {
        Pet pet = owner.getPet("Pet1");
        assertEquals(1, pet.getId());

        pet = owner.getPet("Pet2");
        assertEquals(2, pet.getId());
    }

    @Test
    public void testGetPet_petNotFound() {
        Pet pet = owner.getPet("Pet3");
        assertNull(pet);
    }

    @Test
    public void testGetPet_petIdIsNull() {
        Pet pet = owner.getPet(null);
        assertNull(pet);
    }
}
