package org.springframework.samples.petclinic.owner;

import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.owner.Visit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Visit_getDate_f070dc5932_Test {

    private Visit visit;

    @BeforeEach
    public void setup() {
        visit = new Visit();
    }

    @Test
    public void testGetDate() {
        LocalDate testDate = LocalDate.of(2022, 1, 1);
        visit.setDate(testDate);
        assertEquals(testDate, visit.getDate(), "Expected and actual dates should match");
    }

    @Test
    public void testGetDateWhenNoDateSet() {
        assertEquals(null, visit.getDate(), "Should return null when no date is set");
    }
}
