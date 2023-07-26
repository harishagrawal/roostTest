package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.samples.petclinic.model.Pet;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

public class Owner_getPet_a2da54c166_Test {

    private Owner owner;
    private Pet pet1;
    private Pet pet2;

    @BeforeEach
    public void setup() {
        owner = new Owner();
        pet1 = Mockito.mock(Pet.class);
        pet2 = Mockito.mock(Pet.class);
        when(pet1.getName()).thenReturn("Fido");
        when(pet2.getName()).thenReturn("Rex");
        owner.setPetsInternal(Arrays.asList(pet1, pet2));
    }

    @Test
    public void testGetPet_success() {
        Pet pet = owner.getPet("Fido", true);
        assertEquals(pet1, pet);
    }

    @Test
    public void testGetPet_ignoreNewPet() {
        when(pet1.isNew()).thenReturn(true);
        Pet pet = owner.getPet("Fido", true);
        assertNull(pet);
    }

    @Test
    public void testGetPet_petNotFound() {
        Pet pet = owner.getPet("NonExistentPet", true);
        assertNull(pet);
    }

    @Test
    public void testGetPet_caseInsensitive() {
        Pet pet = owner.getPet("fido", true);
        assertEquals(pet1, pet);
    }
}
