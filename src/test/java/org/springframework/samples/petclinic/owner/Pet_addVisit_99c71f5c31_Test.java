package org.springframework.samples.petclinic.owner;

import org.springframework.samples.petclinic.visit.Visit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Pet_addVisit_99c71f5c31_Test {

    private Pet pet;
    private Visit visit;

    @BeforeEach
    public void setup() {
        pet = new Pet();
        visit = Mockito.mock(Visit.class);
    }

    @Test
    public void testAddVisit() {
        pet.addVisit(visit);
        Set<Visit> visits = new HashSet<>();
        visits.add(visit);
        assertEquals(visits, pet.getVisits());
    }

    @Test
    public void testAddVisitWhenVisitsIsNull() {
        pet.setVisits(null);
        pet.addVisit(visit);
        Set<Visit> visits = new HashSet<>();
        visits.add(visit);
        assertEquals(visits, pet.getVisits());
    }
}
