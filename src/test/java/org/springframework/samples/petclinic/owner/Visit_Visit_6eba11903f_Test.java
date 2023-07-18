package org.springframework.samples.petclinic.owner;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.samples.petclinic.model.Visit;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Visit_Visit_6eba11903f_Test {

    private Visit visit;

    @BeforeEach
    public void setup() {
        visit = new Visit();
    }

    @Test
    public void testVisitDateNow() {
        LocalDate expectedDate = LocalDate.now();
        assertEquals(expectedDate, visit.getDate());
    }

    @Test
    public void testVisitDateAfterChange() {
        LocalDate newDate = LocalDate.of(2022, 1, 1);
        visit.setDate(newDate);
        assertEquals(newDate, visit.getDate());
    }

}
