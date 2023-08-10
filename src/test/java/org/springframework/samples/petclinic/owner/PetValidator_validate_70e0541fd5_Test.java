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

public class PetValidator_validate_70e0541fd5_Test {

    @Mock
    Pet pet;

    PetValidator petValidator;

    Errors errors;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        petValidator = new PetValidator();
        errors = new BeanPropertyBindingResult(pet, "pet");
    }

    @Test
    public void testValidateNameIsNull() {
        when(pet.getName()).thenReturn(null);
        petValidator.validate(pet, errors);
        assertEquals(errors.getFieldError("name").getCode(), "REQUIRED");
    }

    @Test
    public void testValidateTypeIsNull() {
        when(pet.getType()).thenReturn(new PetType());
        petValidator.validate(pet, errors);
        assertEquals(errors.getFieldError("type").getCode(), "REQUIRED");
    }

    @Test
    public void testValidateBirthDateIsNull() {
        when(pet.getBirthDate()).thenReturn(null);
        petValidator.validate(pet, errors);
        assertEquals(errors.getFieldError("birthDate").getCode(), "REQUIRED");
    }

    @Test
    public void testValidateAllFieldsAreValid() {
        when(pet.getName()).thenReturn("Tom");
        when(pet.getType()).thenReturn(new PetType());
        when(pet.getBirthDate()).thenReturn(LocalDate.now());
        petValidator.validate(pet, errors);
        assertEquals(errors.hasErrors(), false);
    }
}
