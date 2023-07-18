package org.springframework.samples.petclinic.owner;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class PetValidator_validate_70e0541fd5_Test {

    @InjectMocks
    private PetValidator petValidator;

    @Mock
    private Pet pet;

    private Errors errors;

    @Before
    public void setup() {
        errors = new BeanPropertyBindingResult(pet, "pet");
    }

    @Test
    public void testValidate_withNoName() {
        petValidator.validate(pet, errors);
        assertEquals("name", errors.getFieldError().getField());
    }

    @Test
    public void testValidate_withNoType() {
        pet.setName("Bobby");
        petValidator.validate(pet, errors);
        assertEquals("type", errors.getFieldError().getField());
    }

    @Test
    public void testValidate_withNoBirthDate() {
        pet.setName("Bobby");
        pet.setType(new PetType());
        petValidator.validate(pet, errors);
        assertEquals("birthDate", errors.getFieldError().getField());
    }

    @Test
    public void testValidate_withAllFields() {
        pet.setName("Bobby");
        pet.setType(new PetType());
        pet.setBirthDate(LocalDate.now());
        petValidator.validate(pet, errors);
        assertEquals(0, errors.getErrorCount());
    }
}
