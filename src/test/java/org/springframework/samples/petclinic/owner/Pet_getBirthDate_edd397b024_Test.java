package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.model.Pet;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Pet_getBirthDate_edd397b024_Test {

    private Pet pet;

    @BeforeEach
    void setup() {
        pet = new Pet();
    }

    @Test
    public void testGetBirthDateWhenBirthDateIsSet() {
        LocalDate birthDate = LocalDate.of(2020, 1, 1);
        pet.setBirthDate(birthDate);
        
        LocalDate result = pet.getBirthDate();
        
        assertEquals(birthDate, result, "The birthdate should match the one that was set");
    }

    @Test
    public void testGetBirthDateWhenBirthDateIsNotSet() {
        LocalDate result = pet.getBirthDate();
        
        assertEquals(null, result, "The birthdate should be null as it was not set");
    }
}
