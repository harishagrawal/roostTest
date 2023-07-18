package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.samples.petclinic.model.Pet;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class Owner_getPet_7f0beed2aa_Test {

    @InjectMocks
    private Owner owner = new Owner();

    @Mock
    private Pet pet = new Pet();

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetPetSuccess() {
        when(pet.getName()).thenReturn("Buddy");
        owner.addPet(pet);

        Pet result = owner.getPet("Buddy");
        assertNotNull(result);
        assertEquals("Buddy", result.getName());
    }

    @Test
    public void testGetPetFailure() {
        when(pet.getName()).thenReturn("Buddy");
        owner.addPet(pet);

        Pet result = owner.getPet("Max");
        assertNull(result);
    }
}
