package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class Owner_getPet_7f0beed2aa_Test {

    @Mock
    private Owner owner;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetPetSuccess() {
        Pet pet = new Pet();
        pet.setName("Buddy");
        when(owner.getPet("Buddy")).thenReturn(pet);
        Pet actualPet = owner.getPet("Buddy");
        assertEquals(pet, actualPet);
    }

    @Test
    public void testGetPetFailure() {
        when(owner.getPet("Buddy")).thenReturn(null);
        Pet actualPet = owner.getPet("Buddy");
        assertEquals(null, actualPet);
    }
}
