package org.springframework.samples.petclinic.owner;

import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.visit.Visit;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Visit_setDate_Test {
    private Visit visit;

    @BeforeEach
    public void setup() {
        visit = new Visit();
    }

    @Test
    public void testSetDateWithValidDate() {
        LocalDate testDate = LocalDate.of(2022, 1, 1);
        visit.setDate(testDate);
        assertEquals(testDate, visit.getDate(), "The date should be set correctly");
    }

    @Test
    public void testSetDateWithNull() {
        visit.setDate(null);
        assertEquals(null, visit.getDate(), "The date should be null");
    }
}
