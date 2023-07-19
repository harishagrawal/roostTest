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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class Owner_getPet_7f0beed2aa_Test {

    @Mock
    private Pet pet;

    @InjectMocks
    private Owner owner;

    @BeforeEach
    public void setup() {
        Set<Pet> pets = new HashSet<>();
        when(pet.getName()).thenReturn("Fido");
        pets.add(pet);
        owner.setPetsInternal(pets);
    }

    @Test
    public void testGetPet_success() {
        Pet retrievedPet = owner.getPet("Fido");
        assertNotNull(retrievedPet);
        assertEquals("Fido", retrievedPet.getName());
    }

    @Test
    public void testGetPet_petNotFound() {
        Pet retrievedPet = owner.getPet("NotFido");
        assertNull(retrievedPet);
    }
}
