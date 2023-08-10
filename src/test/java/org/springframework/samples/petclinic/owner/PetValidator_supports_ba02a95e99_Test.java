package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class PetValidator_supports_ba02a95e99_Test {

    @InjectMocks
    PetValidator petValidator;

    @BeforeEach
    void setUp() {
    }

    @Test
    public void testSupports_whenClassIsPet_thenShouldReturnTrue() {
        boolean supports = petValidator.supports(Pet.class);
        assertTrue(supports, "Expected supports() to return true when class is Pet");
    }

    @Test
    public void testSupports_whenClassIsNotPet_thenShouldReturnFalse() {
        boolean supports = petValidator.supports(String.class);
        assertFalse(supports, "Expected supports() to return false when class is not Pet");
    }
}
