package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.samples.petclinic.model.Pet;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

public class Owner2_getPet_a2da54c166_Test {

    @Mock
    private Owner owner;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetPet_PetExistsAndNotNew() {
        Pet pet = new Pet();
        pet.setName("Fido");
        pet.setNew(false);
        when(owner.getPets()).thenReturn(Arrays.asList(pet));

        Pet actualPet = owner.getPet("Fido", false);
        assertEquals(pet, actualPet);
    }

    @Test
    public void testGetPet_PetExistsAndNew() {
        Pet pet = new Pet();
        pet.setName("Fido");
        pet.setNew(true);
        when(owner.getPets()).thenReturn(Arrays.asList(pet));

        Pet actualPet = owner.getPet("Fido", true);
        assertNull(actualPet);
    }

    @Test
    public void testGetPet_PetDoesNotExist() {
        Pet pet = new Pet();
        pet.setName("Fido");
        pet.setNew(false);
        when(owner.getPets()).thenReturn(Arrays.asList(pet));

        Pet actualPet = owner.getPet("NotFido", false);
        assertNull(actualPet);
    }

    @Test
    public void testGetPet_PetExistsAndNewIgnoreNew() {
        Pet pet = new Pet();
        pet.setName("Fido");
        pet.setNew(true);
        when(owner.getPets()).thenReturn(Arrays.asList(pet));

        Pet actualPet = owner.getPet("Fido", false);
        assertEquals(pet, actualPet);
    }
}
