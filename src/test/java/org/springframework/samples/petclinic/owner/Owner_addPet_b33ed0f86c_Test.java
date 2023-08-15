package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.samples.petclinic.model.Pet;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class Owner_addPet_b33ed0f86c_Test {

    private Owner owner;
    private Pet pet;

    @BeforeEach
    public void setup() {
        owner = new Owner();
        pet = Mockito.mock(Pet.class);
    }

    @Test
    public void testAddPetWhenPetIsNew() {
        Mockito.when(pet.isNew()).thenReturn(true);
        owner.addPet(pet);
        assertTrue(owner.getPets().contains(pet));
    }

    @Test
    public void testAddPetWhenPetIsNotNew() {
        Mockito.when(pet.isNew()).thenReturn(false);
        owner.addPet(pet);
        assertFalse(owner.getPets().contains(pet));
    }
}
