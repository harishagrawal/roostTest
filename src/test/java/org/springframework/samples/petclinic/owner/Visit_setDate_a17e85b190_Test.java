package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.visit.Visit;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Visit_setDate_a17e85b190_Test {

    private Visit testVisit;

    @BeforeEach
    public void setup() {
        this.testVisit = new Visit();
    }

    @Test
    public void testSetDate_success() {
        LocalDate testDate = LocalDate.of(2022, 1, 1);
        this.testVisit.setDate(testDate);
        assertEquals(testDate, this.testVisit.getDate(), "Dates should match");
    }

    @Test
    public void testSetDate_null() {
        this.testVisit.setDate(null);
        assertEquals(null, this.testVisit.getDate(), "Dates should match");
    }

    // TODO: Add more test cases as per the real scenarios
}
