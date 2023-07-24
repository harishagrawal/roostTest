package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.visit.Visit;
import static org.junit.jupiter.api.Assertions.*;

public class PetValidator_supports_ba02a95e99_Test {

    @Test
    public void testSupports() {
        PetValidator petValidator = new PetValidator();

        assertTrue(petValidator.supports(Pet.class), "Pet class should be supported");
        assertTrue(petValidator.supports(PetWithExtraData.class), "Subclass of Pet should be supported");
        assertFalse(petValidator.supports(Visit.class), "Unrelated class should not be supported");
    }

    private static class PetWithExtraData extends Pet {
        // This class intentionally left blank, used for testing supports method with subclass of Pet
    }
}
