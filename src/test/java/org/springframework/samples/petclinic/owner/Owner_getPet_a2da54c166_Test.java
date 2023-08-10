package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class Owner_getPet_a2da54c166_Test {

    @Mock
    private Owner owner;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetPet() {
        Pet pet1 = mock(Pet.class);
        Pet pet2 = mock(Pet.class);

        when(pet1.getName()).thenReturn("Rover");
        when(pet2.getName()).thenReturn("Fido");

        List<Pet> petList = new ArrayList<>();
        petList.add(pet1);
        petList.add(pet2);

        when(owner.getPets()).thenReturn(petList);
        when(owner.getPet("Rover", true)).thenReturn(pet1);

        Pet pet = owner.getPet("Rover", true);
        assertNotNull(pet);
        assertEquals("Rover", pet.getName());
    }

    @Test
    public void testGetPetNotFound() {
        Pet pet1 = mock(Pet.class);
        Pet pet2 = mock(Pet.class);

        when(pet1.getName()).thenReturn("Rover");
        when(pet2.getName()).thenReturn("Fido");

        List<Pet> petList = new ArrayList<>();
        petList.add(pet1);
        petList.add(pet2);

        when(owner.getPets()).thenReturn(petList);
        when(owner.getPet("Max", true)).thenReturn(null);

        Pet pet = owner.getPet("Max", true);
        assertNull(pet);
    }
}
