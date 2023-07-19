package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class Pet_getBirthDate_edd397b024_Test {

    private Pet pet;

    @BeforeEach
    public void setup() {
        pet = new Pet();
    }

    @Test
    public void testGetBirthDate_whenBirthDateIsSet() {
        LocalDate birthDate = LocalDate.of(2020, 1, 1);
        pet.setBirthDate(birthDate);
        assertEquals(birthDate, pet.getBirthDate());
    }

    @Test
    public void testGetBirthDate_whenBirthDateIsNotSet() {
        assertNull(pet.getBirthDate());
    }
}
