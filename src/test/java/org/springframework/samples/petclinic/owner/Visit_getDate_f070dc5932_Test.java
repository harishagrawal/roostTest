package org.springframework.samples.petclinic.visit;

import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.visit.Visit;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Visit_getDate_f070dc5932_Test {

    private Visit visit;

    @BeforeEach
    public void setup() {
        visit = new Visit();
    }

    @Test
    public void testGetDateSuccess() {
        LocalDate expectedDate = LocalDate.of(2022, 1, 1);
        visit.setDate(expectedDate);
        LocalDate actualDate = visit.getDate();
        assertEquals(expectedDate, actualDate, "The dates should match");
    }

    @Test
    public void testGetDateWhenDateIsNull() {
        LocalDate actualDate = visit.getDate();
        assertEquals(null, actualDate, "The date should be null");
    }
}
