package org.springframework.samples.petclinic.owner;

import java.time.LocalDate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.model.BaseEntity;

public class Visit_Visit_6eba11903f_Test {

    private Visit visit;

    @BeforeEach
    public void setup() {
        visit = new Visit();
    }

    @Test
    public void testVisitDateNotNull() {
        LocalDate visitDate = visit.getDate();
        Assertions.assertNotNull(visitDate, "Visit date should not be null");
    }

    @Test
    public void testVisitDateIsToday() {
        LocalDate visitDate = visit.getDate();
        LocalDate today = LocalDate.now();
        Assertions.assertEquals(today, visitDate, "Visit date should be today's date");
    }
}
