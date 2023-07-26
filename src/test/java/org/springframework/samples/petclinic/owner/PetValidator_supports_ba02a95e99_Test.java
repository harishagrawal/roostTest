package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.owner.Pet;

public class PetValidator_supports_ba02a95e99_Test {

    private PetValidator petValidator;

    @BeforeEach
    public void setUp() {
        petValidator = new PetValidator();
    }

    @Test
    public void testSupports_PetClass() {
        boolean result = petValidator.supports(Pet.class);
        Assertions.assertTrue(result, "PetValidator should support Pet class");
    }

    @Test
    public void testSupports_NonPetClass() {
        boolean result = petValidator.supports(String.class);
        Assertions.assertFalse(result, "PetValidator should not support non-Pet class");
    }
}
