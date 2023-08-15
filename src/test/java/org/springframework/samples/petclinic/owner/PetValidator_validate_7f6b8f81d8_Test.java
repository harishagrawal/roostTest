package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class PetValidator_validate_7f6b8f81d8_Test {

    @Mock
    private Pet pet;

    private PetValidator petValidator;

    private Errors errors;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        petValidator = new PetValidator();
        errors = new BeanPropertyBindingResult(pet, "pet");
    }

    @Test
    public void testValidatePetWithName() {
        when(pet.getName()).thenReturn("Tom");
        petValidator.validate(pet, errors);
        assertEquals(0, errors.getErrorCount());
    }

    @Test
    public void testValidatePetWithoutName() {
        when(pet.getName()).thenReturn("");
        petValidator.validate(pet, errors);
        assertEquals(1, errors.getErrorCount());
        assertEquals("name", errors.getFieldError().getField());
    }

    @Test
    public void testValidateNewPetWithoutType() {
        when(pet.isNew()).thenReturn(true);
        petValidator.validate(pet, errors);
        assertEquals(1, errors.getErrorCount());
        assertEquals("type", errors.getFieldError().getField());
    }

    @Test
    public void testValidatePetWithoutBirthDate() {
        when(pet.getBirthDate()).thenReturn(null);
        petValidator.validate(pet, errors);
        assertEquals(1, errors.getErrorCount());
        assertEquals("birthDate", errors.getFieldError().getField());
    }

    @Test
    public void testValidatePetWithBirthDate() {
        when(pet.getBirthDate()).thenReturn(LocalDate.now());
        petValidator.validate(pet, errors);
        assertEquals(0, errors.getErrorCount());
    }
}
