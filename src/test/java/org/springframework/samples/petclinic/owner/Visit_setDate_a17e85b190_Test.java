package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

public class Visit_setDate_a17e85b190_Test {

    private Visit visit;

    @BeforeEach
    public void setup() {
        this.visit = new Visit();
    }

    @Test
    public void testSetDate_ValidDate() {
        LocalDate expectedDate = LocalDate.of(2022, 1, 1);
        this.visit.setDate(expectedDate);
        Assertions.assertEquals(expectedDate, this.visit.getDate());
    }

    @Test
    public void testSetDate_NullDate() {
        this.visit.setDate(null);
        Assertions.assertNull(this.visit.getDate());
    }
}
