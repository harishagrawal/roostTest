package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.model.Pet;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class Pet_getBirthDate_edd397b024_Test {

    private Pet pet;

    @BeforeEach
    void setUp() {
        pet = new Pet();
    }

    @Test
    void testGetBirthDateWhenDateIsSet() {
        LocalDate birthDate = LocalDate.of(2020, 1, 1);
        pet.setBirthDate(birthDate);
        assertEquals(birthDate, pet.getBirthDate());
    }

    @Test
    void testGetBirthDateWhenDateIsNotSet() {
        assertNull(pet.getBirthDate());
    }
}
