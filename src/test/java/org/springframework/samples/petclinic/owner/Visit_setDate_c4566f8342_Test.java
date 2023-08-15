package org.springframework.samples.petclinic.owner;

import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.visit.Visit;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Visit_setDate_c4566f8342_Test {

    private Visit testVisit;

    @BeforeEach
    public void setup() {
        testVisit = new Visit();
    }

    @Test
    public void testSetDate_Success() {
        LocalDate testDate = LocalDate.of(2022, 1, 1);
        testVisit.setDate(testDate);
        assertEquals(testDate, testVisit.getDate(), "The date should be set correctly");
    }

    @Test
    public void testSetDate_Null() {
        testVisit.setDate(null);
        assertEquals(null, testVisit.getDate(), "The date should be null");
    }
}
