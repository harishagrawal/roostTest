package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Pet_setBirthDate_990b03b544_Test {

    private Pet pet;

    @BeforeEach
    public void setup() {
        pet = new Pet();
    }

    @Test
    public void testSetBirthDateWithValidDate() {
        LocalDate testDate = LocalDate.of(2020, 1, 1);
        pet.setBirthDate(testDate);
        assertEquals(testDate, pet.getBirthDate(), "The birth date should be set correctly");
    }

    @Test
    public void testSetBirthDateWithNull() {
        pet.setBirthDate(null);
        assertEquals(null, pet.getBirthDate(), "The birth date should be null");
    }
}
