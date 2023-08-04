package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PetValidator_validate_70e0541fd5_Test {

    private PetValidator validator;
    private Pet pet;
    private Errors errors;

    @BeforeEach
    public void setup() {
        validator = new PetValidator();
        pet = new Pet();
        errors = new BeanPropertyBindingResult(pet, "pet");
    }

    @Test
    public void testValidate_WithEmptyName_ShouldAddAnError() {
        pet.setName("");
        pet.setBirthDate(LocalDate.now());
        pet.setType(new PetType());

        validator.validate(pet, errors);

        assertEquals(1, errors.getFieldErrorCount("name"));
        assertEquals("required", errors.getFieldError("name").getCode());
    }

    @Test
    public void testValidate_WithTypeNull_ShouldAddAnError() {
        pet.setName("Bobby");
        pet.setBirthDate(LocalDate.now());

        validator.validate(pet, errors);

        assertEquals(1, errors.getFieldErrorCount("type"));
        assertEquals("required", errors.getFieldError("type").getCode());
    }

    @Test
    public void testValidate_WithBirthDateNull_ShouldAddAnError() {
        pet.setName("Bobby");
        pet.setType(new PetType());

        validator.validate(pet, errors);

        assertEquals(1, errors.getFieldErrorCount("birthDate"));
        assertEquals("required", errors.getFieldError("birthDate").getCode());
    }

    @Test
    public void testValidate_WithValidPet_ShouldNotAddAnyError() {
        pet.setName("Bobby");
        pet.setBirthDate(LocalDate.now());
        pet.setType(new PetType());

        validator.validate(pet, errors);

        assertEquals(0, errors.getAllErrors().size());
    }
}
