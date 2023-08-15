package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Visit_getDate_efa9e4d8bf_Test {

    private Visit visit;

    @BeforeEach
    public void setup() {
        visit = new Visit();
    }

    @Test
    public void testGetDateWhenDateIsSet() {
        LocalDate expectedDate = LocalDate.now();
        visit.setDate(expectedDate);
        LocalDate actualDate = visit.getDate();
        assertEquals(expectedDate, actualDate, "The expected date does not match the actual date");
    }

    @Test
    public void testGetDateWhenDateIsNotSet() {
        LocalDate actualDate = visit.getDate();
        assertEquals(null, actualDate, "The date should be null as it was not set");
    }
}
