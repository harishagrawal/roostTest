package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.samples.petclinic.owner.Pet;
import org.springframework.samples.petclinic.owner.PetValidator;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class PetValidator_supports_ba02a95e99_Test {

    PetValidator petValidator = new PetValidator();

    @Test
    public void testSupports_withPetClass() {
        assertTrue(petValidator.supports(Pet.class), "PetValidator should support Pet class");
    }

    @Test
    public void testSupports_withNonPetClass() {
        assertFalse(petValidator.supports(String.class), "PetValidator should not support non-Pet class");
    }
}
