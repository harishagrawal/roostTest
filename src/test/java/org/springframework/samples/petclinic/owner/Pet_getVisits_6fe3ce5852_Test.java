package org.springframework.samples.petclinic.owner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import java.util.Arrays;
import java.util.Collection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.visit.Visit;

public class Pet_getVisits_6fe3ce5852_Test {

    private Pet pet;

    @BeforeEach
    public void setup() {
        this.pet = new Pet();
    }

    @Test
    public void testGetVisits_whenNoVisits() {
        Collection<Visit> visits = pet.getVisits();

        assertEquals(0, visits.size(), "Expected no visits");
    }

    @Test
    public void testGetVisits_whenThereAreVisits() {
        Visit visit1 = mock(Visit.class);
        Visit visit2 = mock(Visit.class);

        pet.addVisit(visit1);
        pet.addVisit(visit2);

        Collection<Visit> visits = pet.getVisits();

        assertEquals(2, visits.size(), "Expected two visits");
        assertEquals(Arrays.asList(visit1, visit2), visits, "Expected visits to match added visits");
    }
}
