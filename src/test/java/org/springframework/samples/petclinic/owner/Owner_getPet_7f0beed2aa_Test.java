package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.samples.petclinic.model.Pet;
import org.springframework.samples.petclinic.model.Owner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class Owner_getPet_7f0beed2aa_Test {

    @Mock
    private Owner owner;

    @Mock
    private Pet pet;

    @BeforeEach
    public void setup() {
        when(owner.getPet(anyString())).thenReturn(pet);
    }

    @Test
    public void testGetPetSuccess() {
        when(owner.getPet("Rover")).thenReturn(pet);
        Pet retrievedPet = owner.getPet("Rover");
        assertEquals(pet, retrievedPet);
    }

    @Test
    public void testGetPetFailure() {
        when(owner.getPet("Rover")).thenReturn(null);
        Pet retrievedPet = owner.getPet("Rover");
        assertNull(retrievedPet);
    }
}
