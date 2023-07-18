package org.springframework.samples.petclinic.owner;

import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.visit.Visit;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Visit_getDate_f070dc5932_Test {
    
    private Visit visit;

    @BeforeEach
    public void setup() {
        this.visit = new Visit();
    }

    @Test
    public void testGetDateWhenDateIsSet() {
        LocalDate expectedDate = LocalDate.now();
        this.visit.setDate(expectedDate);
        LocalDate actualDate = this.visit.getDate();
        assertEquals(expectedDate, actualDate, "The expected date does not match the actual date");
    }

    @Test
    public void testGetDateWhenDateIsNotSet() {
        LocalDate actualDate = this.visit.getDate();
        assertEquals(null, actualDate, "The date should be null as it has not been set");
    }
}
