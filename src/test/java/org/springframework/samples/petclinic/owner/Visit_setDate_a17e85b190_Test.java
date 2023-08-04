package org.springframework.samples.petclinic.owner;

import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.visit.Visit;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Visit_setDate_a17e85b190_Test {

    private Visit visit;

    @BeforeEach
    public void setup() {
        this.visit = new Visit();
    }

    @Test
    public void testSetDate_Success() {
        LocalDate expectedDate = LocalDate.now();
        this.visit.setDate(expectedDate);
        assertEquals(expectedDate, this.visit.getDate());
    }

    @Test
    public void testSetDate_Null() {
        this.visit.setDate(null);
        assertEquals(null, this.visit.getDate());
    }
}
