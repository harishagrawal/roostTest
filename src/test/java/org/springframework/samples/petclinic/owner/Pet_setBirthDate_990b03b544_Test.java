package org.springframework.samples.petclinic.owner;

import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Pet_setBirthDate_990b03b544_Test {

    private Pet pet;

    @BeforeEach
    public void setup() {
        pet = new Pet();
    }

    @Test
    public void testSetBirthDateWithValidDate() {
        LocalDate birthDate = LocalDate.of(2020, 1, 1);
        pet.setBirthDate(birthDate);
        assertEquals(birthDate, pet.getBirthDate());
    }

    @Test
    public void testSetBirthDateWithNullValue() {
        pet.setBirthDate(null);
        assertEquals(null, pet.getBirthDate());
    }
}
