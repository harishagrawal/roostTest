package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.samples.petclinic.model.Pet;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class Owner_getPet_7f0beed2aa_Test {

    @Mock
    private Pet pet;

    @InjectMocks
    private Owner owner;

    @BeforeEach
    void setUp() {
        owner = new Owner();
        pet = new Pet();
        owner.addPet(pet);
    }

    @Test
    void testGetPet_success() {
        when(pet.getName()).thenReturn("Fido");
        Pet foundPet = owner.getPet("Fido");
        assertNotNull(foundPet);
        assertEquals("Fido", foundPet.getName());
    }

    @Test
    void testGetPet_petNotFound() {
        when(pet.getName()).thenReturn("Fido");
        Pet foundPet = owner.getPet("Buddy");
        assertNull(foundPet);
    }
}
