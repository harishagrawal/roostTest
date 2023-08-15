package org.springframework.samples.petclinic.owner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.samples.petclinic.model.Pet;

public class Owner2_getPet_981a356ffc_Test {

    private Owner2 owner2;

    @Mock
    private Pet pet;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        owner2 = new Owner2();
    }

    @Test
    public void testGetPetSuccess() {
        when(pet.getName()).thenReturn("Fido");
        owner2.addPet(pet);
        Pet actualPet = owner2.getPet("Fido");
        assertEquals(pet, actualPet);
    }

    @Test
    public void testGetPetFailure() {
        when(pet.getName()).thenReturn("Fido");
        owner2.addPet(pet);
        Pet actualPet = owner2.getPet("NotFido");
        assertNull(actualPet);
    }
}
