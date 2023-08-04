package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@ExtendWith(SpringExtension.class)
@SpringBootTest
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

        assertEquals(birthDate, actualBirthDate, "The birth date returned was not the one set");
    }

    @Test
    public void testGetBirthDateWhenBirthDateIsNotSet() {
        LocalDate actualBirthDate = pet.getBirthDate();

        assertNull(actualBirthDate, "The birth date should be null as it was not set");
    }
}
