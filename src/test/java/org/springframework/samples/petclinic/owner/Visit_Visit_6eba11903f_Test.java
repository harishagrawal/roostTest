package org.springframework.samples.petclinic.owner;

import java.time.LocalDate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.model.Visit;

public class Visit_Visit_6eba11903f_Test {

    private Visit visit;

    @BeforeEach
    public void setup() {
        this.visit = new Visit();
    }

    @Test
    public void testVisitDateIsToday() {
        LocalDate expectedDate = LocalDate.now();
        LocalDate actualDate = this.visit.getDate();
        Assertions.assertEquals(expectedDate, actualDate, "The visit date should be set to the current date");
    }

    @Test
    public void testVisitDateIsNotTomorrow() {
        LocalDate notExpectedDate = LocalDate.now().plusDays(1);
        LocalDate actualDate = this.visit.getDate();
        Assertions.assertNotEquals(notExpectedDate, actualDate, "The visit date should not be set to tomorrow's date");
    }
}
