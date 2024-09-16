package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.samples.petclinic.model.Pet;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

public class Owner_getPet_a2da54c166_Test {

    @Mock
    private Owner owner;

    @Mock
    private Pet pet1;

    @Mock
    private Pet pet2;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetPet() {
        List<Pet> pets = Arrays.asList(pet1, pet2);
        when(owner.getPets()).thenReturn(pets);
        when(pet1.getName()).thenReturn("Rover");
        when(pet2.getName()).thenReturn("Fido");
        when(pet1.isNew()).thenReturn(false);
        when(pet2.isNew()).thenReturn(true);

        Pet pet = owner.getPet("rover", false);
        Assertions.assertEquals(pet1, pet, "Expected pet is Rover");

        pet = owner.getPet("fido", true);
        Assertions.assertNull(pet, "Expected no pet as Fido is new and ignoreNew is true");
    }

    @Test
    public void testGetPetWithNonExistentName() {
        List<Pet> pets = Arrays.asList(pet1, pet2);
        when(owner.getPets()).thenReturn(pets);
        when(pet1.getName()).thenReturn("Rover");
        when(pet2.getName()).thenReturn("Fido");

        Pet pet = owner.getPet("buddy", false);
        Assertions.assertNull(pet, "Expected no pet as Buddy does not exist");
    }

    @Test
    public void testGetPetWithNullName() {
        List<Pet> pets = Arrays.asList(pet1, pet2);
        when(owner.getPets()).thenReturn(pets);
        when(pet1.getName()).thenReturn("Rover");
        when(pet2.getName()).thenReturn("Fido");

        Pet pet = owner.getPet(null, false);
        Assertions.assertNull(pet, "Expected no pet as null name provided");
    }
}
