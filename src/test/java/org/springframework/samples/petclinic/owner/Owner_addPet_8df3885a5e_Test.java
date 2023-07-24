package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.samples.petclinic.model.Pet;

import static org.junit.jupiter.api.Assertions.*;

class Owner_addPet_8df3885a5e_Test {

    private Owner owner;
    private Pet pet;

    @BeforeEach
    void setUp() {
        owner = new Owner();
        pet = Mockito.mock(Pet.class);
    }

    @Test
    void testAddPetWhenPetIsNew() {
        Mockito.when(pet.isNew()).thenReturn(true);

        owner.addPet(pet);

        assertTrue(owner.getPets().contains(pet));
    }

    @Test
    void testAddPetWhenPetIsNotNew() {
        Mockito.when(pet.isNew()).thenReturn(false);

        owner.addPet(pet);

        assertFalse(owner.getPets().contains(pet));
    }
}
