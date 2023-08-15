package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.samples.petclinic.model.Pet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class Owner_getPet_981a356ffc_Test {

    @Mock
    private Pet pet;

    @InjectMocks
    private Owner owner;

    @BeforeEach
    public void setup() {
        owner.addPet(pet);
    }

    @Test
    public void testGetPetSuccess() {
        when(pet.getName()).thenReturn("Fido");

        Pet result = owner.getPet("Fido");
        assertNotNull(result);
        assertEquals("Fido", result.getName());
    }

    @Test
    public void testGetPetFailure() {
        when(pet.getName()).thenReturn("Fido");

        Pet result = owner.getPet("Buddy");
        assertNull(result);
    }
}
