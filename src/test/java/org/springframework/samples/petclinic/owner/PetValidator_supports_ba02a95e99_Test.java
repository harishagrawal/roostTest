package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.owner.Pet;
import org.springframework.samples.petclinic.owner.PetValidator;

import static org.junit.jupiter.api.Assertions.*;

class PetValidator_supports_ba02a95e99_Test {

    private PetValidator petValidator;

    @BeforeEach
    void setUp() {
        petValidator = new PetValidator();
    }

    @Test
    void testSupports_WithPetClass() {
        boolean result = petValidator.supports(Pet.class);
        assertTrue(result, "PetValidator should support Pet class");
    }

    @Test
    void testSupports_WithNonPetClass() {
        boolean result = petValidator.supports(String.class);
        assertFalse(result, "PetValidator should not support non-Pet class");
    }
}
