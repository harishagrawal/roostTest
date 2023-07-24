package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class PetValidator_validate_70e0541fd5_Test {

    @InjectMocks
    private PetValidator petValidator;

    private Pet pet;
    private Errors errors;

    @BeforeEach
    public void setup() {
        pet = new Pet();
        errors = new BeanPropertyBindingResult(pet, "pet");
    }

    @Test
    public void testValidate_withNoName_shouldAddNameError() {
        petValidator.validate(pet, errors);
        assertEquals(1, errors.getErrorCount());
        assertEquals("name", errors.getFieldError().getField());
    }

    @Test
    public void testValidate_withNoType_shouldAddTypeError() {
        pet.setName("Fluffy");
        petValidator.validate(pet, errors);
        assertEquals(1, errors.getErrorCount());
        assertEquals("type", errors.getFieldError().getField());
    }

    @Test
    public void testValidate_withNoBirthDate_shouldAddBirthDateError() {
        pet.setName("Fluffy");
        pet.setType(new PetType());
        petValidator.validate(pet, errors);
        assertEquals(1, errors.getErrorCount());
        assertEquals("birthDate", errors.getFieldError().getField());
    }

    @Test
    public void testValidate_withAllFields_shouldNotAddAnyError() {
        pet.setName("Fluffy");
        pet.setType(new PetType());
        pet.setBirthDate(LocalDate.now());
        petValidator.validate(pet, errors);
        assertEquals(0, errors.getErrorCount());
    }
}
