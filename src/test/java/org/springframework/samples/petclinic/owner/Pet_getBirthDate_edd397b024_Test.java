package org.springframework.samples.petclinic.owner;

import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class Pet_getBirthDate_edd397b024_Test {

    private Pet pet;

    @BeforeEach
    public void setup() {
        pet = new Pet();
    }

    @Test
    public void testGetBirthDateWhenBirthDateIsSet() {
        LocalDate birthDate = LocalDate.of(2020, 1, 1);
        pet.setBirthDate(birthDate);
        LocalDate actualBirthDate = pet.getBirthDate();
        assertEquals(birthDate, actualBirthDate, "Birth date should match the one set");
    }

    @Test
    public void testGetBirthDateWhenBirthDateIsNotSet() {
        LocalDate actualBirthDate = pet.getBirthDate();
        assertNull(actualBirthDate, "Birth date should be null if not set");
    }
}
