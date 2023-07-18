package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.samples.petclinic.visit.Visit;

import java.util.Collection;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class Pet_getVisits_6fe3ce5852_Test {

    private Pet pet;

    @BeforeEach
    public void setup() {
        pet = new Pet();
    }

    @Test
    public void testGetVisits_WhenNoVisits() {
        Collection<Visit> visits = pet.getVisits();
        assertTrue(visits.isEmpty(), "Visits collection should be empty when no visits are added");
    }

    @Test
    public void testGetVisits_WhenVisitsExist() {
        Visit visit1 = new Visit();
        Visit visit2 = new Visit();
        HashSet<Visit> visitSet = new HashSet<>();
        visitSet.add(visit1);
        visitSet.add(visit2);
        pet.setVisitsInternal(visitSet);

        Collection<Visit> visits = pet.getVisits();
        assertEquals(2, visits.size(), "Visits collection should contain 2 visits when 2 visits are added");
        assertTrue(visits.contains(visit1), "Visits collection should contain visit1");
        assertTrue(visits.contains(visit2), "Visits collection should contain visit2");
    }
}
