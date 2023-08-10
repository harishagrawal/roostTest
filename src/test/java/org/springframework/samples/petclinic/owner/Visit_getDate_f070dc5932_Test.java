package org.springframework.samples.petclinic.owner;

import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.visit.Visit;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class Visit_getDate_f070dc5932_Test {

    private Visit visit;
    
    @BeforeEach
    public void setup() {
        visit = new Visit();
    }

    @Test
    public void testGetDateSuccess() {
        LocalDate testDate = LocalDate.of(2022, 1, 1);
        visit.setDate(testDate);
        LocalDate resultDate = visit.getDate();
        assertEquals(testDate, resultDate, "The returned date should match the set date");
    }
    
    @Test
    public void testGetDateFailure() {
        LocalDate testDate = LocalDate.of(2022, 1, 1);
        visit.setDate(testDate);
        LocalDate wrongDate = LocalDate.of(2023, 1, 1);
        LocalDate resultDate = visit.getDate();
        assertNotEquals(wrongDate, resultDate, "The returned date should not match the wrong date");
    }
}
