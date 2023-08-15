package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.samples.petclinic.model.Pet;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

public class Owner2_getPet_f9297dd0a1_Test {

    private Owner owner;
    private Pet pet1;
    private Pet pet2;

    @BeforeEach
    public void setup() {
        owner = new Owner();
        pet1 = Mockito.mock(Pet.class);
        pet2 = Mockito.mock(Pet.class);
    }

    @Test
    public void testGetPet_whenPetExists() {
        when(pet1.isNew()).thenReturn(false);
        when(pet1.getId()).thenReturn(1);
        when(pet2.isNew()).thenReturn(false);
        when(pet2.getId()).thenReturn(2);

        List<Pet> pets = Arrays.asList(pet1, pet2);
        owner.setPetsInternal(pets);

        Pet foundPet = owner.getPet("Pet1", false);
        assertEquals(pet1, foundPet);
    }

    @Test
    public void testGetPet_whenPetDoesNotExist() {
        when(pet1.isNew()).thenReturn(false);
        when(pet1.getId()).thenReturn(1);
        when(pet2.isNew()).thenReturn(false);
        when(pet2.getId()).thenReturn(2);

        List<Pet> pets = Arrays.asList(pet1, pet2);
        owner.setPetsInternal(pets);

        Pet foundPet = owner.getPet("Pet3", false);
        assertNull(foundPet);
    }

    @Test
    public void testGetPet_whenPetIsNew() {
        when(pet1.isNew()).thenReturn(true);
        when(pet1.getId()).thenReturn(1);
        when(pet2.isNew()).thenReturn(false);
        when(pet2.getId()).thenReturn(2);

        List<Pet> pets = Arrays.asList(pet1, pet2);
        owner.setPetsInternal(pets);

        Pet foundPet = owner.getPet("Pet1", true);
        assertNull(foundPet);
    }
}
