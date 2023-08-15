package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class Pet_getBirthDate_7f1e9ebfb7_Test {

    private Pet pet;

    @BeforeEach
    public void setup() {
        pet = new Pet();
    }

    @Test
    public void testGetBirthDateWhenBirthDateIsSet() {
        LocalDate birthDate = LocalDate.now();
        pet.setBirthDate(birthDate);
        assertEquals(birthDate, pet.getBirthDate());
    }

    @Test
    public void testGetBirthDateWhenBirthDateIsNotSet() {
        assertNull(pet.getBirthDate());
    }
}
