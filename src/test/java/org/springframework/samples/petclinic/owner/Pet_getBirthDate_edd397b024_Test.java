package org.springframework.samples.petclinic.owner;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Pet_getBirthDate_edd397b024_Test {

    private Pet pet;

    @BeforeEach
    public void setup() {
        this.pet = new Pet();
    }

    @Test
    public void testGetBirthDate() {
        LocalDate birthDate = LocalDate.of(2010, 1, 1);
        this.pet.setBirthDate(birthDate);
        assertEquals(birthDate, this.pet.getBirthDate(), "Expected and actual birth dates do not match");
    }

    @Test
    public void testGetBirthDate_Null() {
        this.pet.setBirthDate(null);
        assertEquals(null, this.pet.getBirthDate(), "Expected null but got a date");
    }
}
