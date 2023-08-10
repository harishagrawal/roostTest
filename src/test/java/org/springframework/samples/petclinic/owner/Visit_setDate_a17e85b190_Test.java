package org.springframework.samples.petclinic.owner;

import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.visit.Visit;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Visit_setDate_a17e85b190_Test {

    private Visit testVisit;

    @BeforeEach
    public void setup() {
        this.testVisit = new Visit();
    }

    @Test
    public void testSetDateSuccess() {
        LocalDate testDate = LocalDate.of(2022, 1, 1);
        this.testVisit.setDate(testDate);
        assertEquals(testDate, this.testVisit.getDate(), "The date set in the entity should match the test date");
    }

    @Test
    public void testSetDateNull() {
        this.testVisit.setDate(null);
        assertEquals(null, this.testVisit.getDate(), "The date set in the entity should be null");
    }
}
