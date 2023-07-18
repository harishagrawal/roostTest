package org.springframework.samples.petclinic.owner;

import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Visit_setDate_a17e85b190_Test {

    private Visit visit;

    @BeforeEach
    public void setup() {
        this.visit = new Visit();
    }

    @Test
    public void testSetDateSuccess() {
        LocalDate testDate = LocalDate.of(2022, 1, 1);
        this.visit.setDate(testDate);
        assertEquals(testDate, this.visit.getDate());
    }

    @Test
    public void testSetDateNull() {
        this.visit.setDate(null);
        assertEquals(null, this.visit.getDate());
    }
}
