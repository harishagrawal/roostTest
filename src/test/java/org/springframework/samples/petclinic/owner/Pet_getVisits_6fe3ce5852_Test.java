package org.springframework.samples.petclinic.owner;

import java.util.Collection;
import java.util.HashSet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.visit.Visit;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Pet_getVisits_6fe3ce5852_Test {

    Pet pet;

    @BeforeEach
    public void setup() {
        pet = new Pet();
    }

    @Test
    public void testGetVisitsWhenThereAreNoVisits() {
        Collection<Visit> visits = pet.getVisits();
        assertTrue(visits.isEmpty(), "Visits collection should be empty when no visits are added");
    }

    @Test
    public void testGetVisitsWhenThereAreVisits() {
        Visit visit1 = new Visit();
        Visit visit2 = new Visit();

        Collection<Visit> visitsToAdd = new HashSet<>();
        visitsToAdd.add(visit1);
        visitsToAdd.add(visit2);

        pet.setVisits(visitsToAdd);

        Collection<Visit> retrievedVisits = pet.getVisits();
        assertEquals(visitsToAdd, retrievedVisits, "Visits retrieved should match the visits added");
    }
}
