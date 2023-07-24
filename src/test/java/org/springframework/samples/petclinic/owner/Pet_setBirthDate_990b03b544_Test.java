package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.model.Pet;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class Pet_setBirthDate_990b03b544_Test {

    private Pet pet;

    @BeforeEach
    public void setup() {
        pet = new Pet();
    }

    @Test
    public void testSetBirthDate() {
        LocalDate birthDate = LocalDate.of(2020, 1, 1);
        pet.setBirthDate(birthDate);
        assertEquals(birthDate, pet.getBirthDate(), "Expected and actual birth dates do not match");
    }

    @Test
    public void testSetBirthDateNull() {
        pet.setBirthDate(null);
        assertNull(pet.getBirthDate(), "Birth date should be null");
    }

}
