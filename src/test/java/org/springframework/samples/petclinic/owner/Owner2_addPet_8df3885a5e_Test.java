package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.samples.petclinic.model.Pet;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Owner2_addPet_8df3885a5e_Test {

    private Owner owner;
    private Pet pet;

    @BeforeEach
    public void setup() {
        owner = new Owner();
        pet = Mockito.mock(Pet.class);
    }

    @Test
    public void testAddPetSuccess() {
        Mockito.when(pet.isNew()).thenReturn(true);
        owner.addPet(pet);
        Set<Pet> pets = owner.getPets();
        assertTrue(pets.contains(pet));
    }

    @Test
    public void testAddPetFailure() {
        Mockito.when(pet.isNew()).thenReturn(false);
        owner.addPet(pet);
        Set<Pet> pets = owner.getPets();
        assertEquals(new HashSet<>(), pets);
    }
}
