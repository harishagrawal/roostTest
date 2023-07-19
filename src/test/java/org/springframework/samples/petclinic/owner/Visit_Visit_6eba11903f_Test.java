package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.model.Visit;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class Visit_Visit_6eba11903f_Test {

    @Test
    public void testVisitDateToday() {
        Visit visit = new Visit();
        visit.setDate(LocalDate.now());
        assertEquals(LocalDate.now(), visit.getDate());
    }

    @Test
    public void testVisitDateNotTomorrow() {
        Visit visit = new Visit();
        visit.setDate(LocalDate.now());
        assertNotEquals(LocalDate.now().plusDays(1), visit.getDate());
    }
}
