package org.springframework.samples.petclinic.owner;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.visit.Visit;

import java.util.HashSet;
import java.util.Set;

public class Pet_addVisit_99c71f5c31_Test {

    private Pet pet;
    private Visit visit1;
    private Visit visit2;

    @BeforeEach
    public void setup() {
        pet = new Pet();
        visit1 = mock(Visit.class);
        visit2 = mock(Visit.class);
    }

    @Test
    public void testAddVisit() {
        pet.addVisit(visit1);
        Set<Visit> visits = pet.getVisits();
        assertTrue(visits.contains(visit1));
    }

    @Test
    public void testAddMultipleVisits() {
        pet.addVisit(visit1);
        pet.addVisit(visit2);
        Set<Visit> visits = pet.getVisits();
        assertTrue(visits.contains(visit1));
        assertTrue(visits.contains(visit2));
    }

    @Test
    public void testAddVisitToExistingVisits() {
        Set<Visit> initialVisits = new HashSet<>();
        initialVisits.add(visit1);
        pet.setVisits(initialVisits);

        pet.addVisit(visit2);
        Set<Visit> visits = pet.getVisits();
        assertTrue(visits.contains(visit1));
        assertTrue(visits.contains(visit2));
    }
}
