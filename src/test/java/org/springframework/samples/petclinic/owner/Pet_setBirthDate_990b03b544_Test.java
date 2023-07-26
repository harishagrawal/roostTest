package org.springframework.samples.petclinic.owner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Pet_setBirthDate_990b03b544_Test {
    private Pet testPet;

    @BeforeEach
    public void setup() {
        testPet = new Pet();
    }

    @Test
    public void testSetBirthDate_ValidDate() {
        LocalDate birthDate = LocalDate.of(2020, 1, 1);
        testPet.setBirthDate(birthDate);
        assertEquals(birthDate, testPet.getBirthDate(), "The birthdate should be set correctly");
    }

    @Test
    public void testSetBirthDate_NullDate() {
        assertThrows(NullPointerException.class, () -> {
            testPet.setBirthDate(null);
        }, "Setting birthdate to null should throw NullPointerException");
    }

    @Test
    public void testSetBirthDate_FutureDate() {
        LocalDate futureDate = LocalDate.now().plusDays(1);
        assertThrows(IllegalArgumentException.class, () -> {
            testPet.setBirthDate(futureDate);
        }, "Setting birthdate to a future date should throw IllegalArgumentException");
    }
}
