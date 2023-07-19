package org.springframework.samples.petclinic.owner;

import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.model.Pet;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Pet_getBirthDate_edd397b024_Test {

    private Pet pet;

    @BeforeEach
    public void setUp() {
        pet = new Pet();
    }

    @Test
    public void testGetBirthDateWithValidDate() {
        LocalDate expectedDate = LocalDate.of(2020, 1, 1);
        pet.setBirthDate(expectedDate);

        LocalDate actualDate = pet.getBirthDate();

        assertEquals(expectedDate, actualDate, "Expected and actual birth dates should match");
    }

    @Test
    public void testGetBirthDateWhenDateIsNull() {
        pet.setBirthDate(null);

        LocalDate actualDate = pet.getBirthDate();

        assertEquals(null, actualDate, "Expected birth date should be null when not set");
    }
}
