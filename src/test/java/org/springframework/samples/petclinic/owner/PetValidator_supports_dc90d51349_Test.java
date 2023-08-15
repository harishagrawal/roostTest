package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

@ExtendWith(MockitoExtension.class)
public class PetValidatorSupportsDc90d51349Test {

    @InjectMocks
    private PetValidator petValidator;

    private Class<?> petClass;
    private Class<?> stringClass;

    @BeforeEach
    public void setup() {
        petClass = Pet.class;
        stringClass = String.class;
    }

    @Test
    public void testSupportsWithPetClass() {
        boolean result = petValidator.supports(petClass);
        assertTrue(result, "Expected supports() to return true for Pet class");
    }

    @Test
    public void testSupportsWithNonPetClass() {
        boolean result = petValidator.supports(stringClass);
        assertFalse(result, "Expected supports() to return false for non-Pet class");
    }
}
