package org.springframework.samples.petclinic.owner;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class PetValidator_validate_70e0541fd5_Test {

    @Mock
    private Pet pet;

    private PetValidator petValidator;
    private Errors errors;

    @Before
    public void setUp() {
        petValidator = new PetValidator();
        errors = new BindException(pet, "pet");
    }

    @Test
    public void testValidateWithNoName() {
        pet.setName("");
        petValidator.validate(pet, errors);
        assertTrue(errors.hasErrors());
        assertEquals("required", errors.getFieldError("name").getCode());
    }

    @Test
    public void testValidateWithNoTypeAndNewPet() {
        pet.setNew(true);
        petValidator.validate(pet, errors);
        assertTrue(errors.hasErrors());
        assertEquals("required", errors.getFieldError("type").getCode());
    }

    @Test
    public void testValidateWithNoBirthDate() {
        petValidator.validate(pet, errors);
        assertTrue(errors.hasErrors());
        assertEquals("required", errors.getFieldError("birthDate").getCode());
    }

    @Test
    public void testValidateWithValidPet() {
        pet.setName("Buddy");
        PetType petType = new PetType();
        pet.setType(petType);
        pet.setBirthDate(LocalDate.now());
        petValidator.validate(pet, errors);
        assertTrue(!errors.hasErrors());
    }
}
