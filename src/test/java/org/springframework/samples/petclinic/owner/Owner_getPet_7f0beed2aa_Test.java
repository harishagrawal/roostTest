package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.samples.petclinic.model.Pet;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class Owner_getPet_7f0beed2aa_Test {

    @Mock
    Pet pet;

    @InjectMocks
    Owner owner;

    @BeforeEach
    void setUp() {
        Set<Pet> pets = new HashSet<>();
        when(pet.getName()).thenReturn("Fido");
        pets.add(pet);
        owner.setPetsInternal(pets);
    }

    @Test
    void testGetPetSuccess() {
        Pet foundPet = owner.getPet("Fido");
        assertNotNull(foundPet);
        assertEquals("Fido", foundPet.getName());
    }

    @Test
    void testGetPetNotFound() {
        Pet foundPet = owner.getPet("NotFido");
        assertNull(foundPet);
    }
}
