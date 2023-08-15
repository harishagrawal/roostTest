package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.model.Visit;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class Visit_Visit_02adeb17dc_Test {

    private Visit visit;

    @BeforeEach
    public void setup() {
        visit = new Visit();
    }

    @Test
    public void testVisitCreationDate() {
        LocalDate expectedDate = LocalDate.now();
        LocalDate actualDate = visit.getDate();
        assertEquals(expectedDate, actualDate, "The date of the visit should be today's date");
    }

    @Test
    public void testVisitCreationDateAfterOneDay() {
        LocalDate expectedDate = LocalDate.now().plusDays(1);
        LocalDate actualDate = visit.getDate();
        assertNotEquals(expectedDate, actualDate, "The date of the visit should not be tomorrow's date");
    }
}
