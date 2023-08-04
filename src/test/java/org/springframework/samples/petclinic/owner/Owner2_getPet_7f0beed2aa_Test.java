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
public class Owner2_getPet_7f0beed2aa_Test {

    @InjectMocks
    Owner owner = new Owner();

    @Mock
    Pet pet = new Pet();

    @BeforeEach
    void setUp() {
        when(pet.getName()).thenReturn("Fido");
        owner.addPet(pet);
    }

    @Test
    public void testGetPet_success() {
        Pet resultPet = owner.getPet("Fido");
        assertNotNull(resultPet, "Expected non-null pet");
        assertEquals("Fido", resultPet.getName(), "Expected pet name to be Fido");
    }

    @Test
    public void testGetPet_failure() {
        Pet resultPet = owner.getPet("NotFido");
        assertNull(resultPet, "Expected null pet as pet name does not exist");
    }
}
