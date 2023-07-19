package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PetValidator_validate_70e0541fd5_Test {

    private Validator validator;
    private Pet pet;
    private Errors errors;

    @BeforeEach
    public void setUp() {
        validator = new PetValidator();
        pet = new Pet();
        errors = new BeanPropertyBindingResult(pet, "pet");
    }

    @Test
    public void testValidateName() {
        pet.setName("");
        validator.validate(pet, errors);
        assertEquals("REQUIRED", errors.getFieldError("name").getCode());

        errors = new BeanPropertyBindingResult(pet, "pet");
        pet.setName("Bobby");
        validator.validate(pet, errors);
        assertEquals(null, errors.getFieldError("name"));
    }

    @Test
    public void testValidateType() {
        pet.setNew(true);
        pet.setType(null);
        validator.validate(pet, errors);
        assertEquals("REQUIRED", errors.getFieldError("type").getCode());

        errors = new BeanPropertyBindingResult(pet, "pet");
        pet.setType(new PetType());
        validator.validate(pet, errors);
        assertEquals(null, errors.getFieldError("type"));
    }

    @Test
    public void testValidateBirthDate() {
        pet.setBirthDate(null);
        validator.validate(pet, errors);
        assertEquals("REQUIRED", errors.getFieldError("birthDate").getCode());

        errors = new BeanPropertyBindingResult(pet, "pet");
        pet.setBirthDate(LocalDate.now());
        validator.validate(pet, errors);
        assertEquals(null, errors.getFieldError("birthDate"));
    }
}
