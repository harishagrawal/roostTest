package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Pet_getBirthDate_edd397b024_Test {

    private Pet pet;

    @BeforeEach
    public void setUp() {
        this.pet = new Pet();
    }

    @Test
    public void testGetBirthDate() {
        LocalDate birthDate = LocalDate.of(2020, 1, 1);
        this.pet.setBirthDate(birthDate);
        assertEquals(birthDate, this.pet.getBirthDate(), "Check if getBirthDate returns correct birth date");
    }

    @Test
    public void testGetBirthDateNull() {
        assertEquals(null, this.pet.getBirthDate(), "Check if getBirthDate returns null when birth date is not set");
    }
}
