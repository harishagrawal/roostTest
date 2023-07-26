package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.samples.petclinic.model.Pet;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class Owner2_addPet_8df3885a5e_Test {

    @Mock
    private Pet pet;

    private Owner owner;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        owner = new Owner();
    }

    @Test
    public void testAddPetSuccess() {
        when(pet.isNew()).thenReturn(true);
        owner.addPet(pet);
        assertTrue(owner.getPets().contains(pet));
    }

    @Test
    public void testAddPetFailure() {
        when(pet.isNew()).thenReturn(false);
        owner.addPet(pet);
        assertFalse(owner.getPets().contains(pet));
    }
}
