package org.springframework.samples.petclinic.owner;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.visit.Visit;

class Pet_addVisit_99c71f5c31_Test {

    private Pet pet;
    private Visit visit;

    @BeforeEach
    public void setup() {
        pet = new Pet();
        visit = mock(Visit.class);
    }

    @Test
    public void testAddVisit() {
        pet.addVisit(visit);
        assertTrue(pet.getVisits().contains(visit));
    }
}
