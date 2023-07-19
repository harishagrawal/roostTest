package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.samples.petclinic.model.Pet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

public class Owner_getPet_7f0beed2aa_Test {

    @InjectMocks
    private Owner owner;

    @Mock
    private Pet pet;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
        owner = new Owner();
        pet = new Pet();
    }

    @Test
    public void testGetPet_success() {
        String petName = "Fido";
        when(pet.getName()).thenReturn(petName);
        owner.addPet(pet);
        Pet retrievedPet = owner.getPet(petName);
        assertEquals(petName, retrievedPet.getName());
    }

    @Test
    public void testGetPet_petNotFound() {
        String petName = "Fido";
        Pet retrievedPet = owner.getPet(petName);
        assertNull(retrievedPet);
    }
}
