package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class Owner2_getPet_7f0beed2aa_Test {

    @InjectMocks
    Owner owner = new Owner();

    @Mock
    Pet pet = new Pet();

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetPetSuccess() {
        String petName = "Fido";
        when(pet.getName()).thenReturn(petName);
        owner.addPet(pet);

        Pet retrievedPet = owner.getPet(petName);
        assertEquals(petName, retrievedPet.getName());
    }

    @Test
    public void testGetPetFailure() {
        String petName = "Fido";
        when(pet.getName()).thenReturn(petName);
        owner.addPet(pet);

        Pet retrievedPet = owner.getPet("NotFido");
        assertEquals(null, retrievedPet);
    }
}
