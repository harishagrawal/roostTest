package org.springframework.samples.petclinic.owner;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.visit.Visit;

public class Pet_getVisits_e2a563d9d4_Test {

    private Pet pet;

    @BeforeEach
    public void setup() {
        pet = new Pet();
    }

    @Test
    public void testGetVisits_WhenNoVisits() {
        Collection<Visit> visits = pet.getVisits();
        assertEquals(0, visits.size(), "Expected no visits");
    }

    @Test
    public void testGetVisits_WhenThereAreVisits() {
        Visit visit1 = new Visit();
        Visit visit2 = new Visit();
        pet.setVisits(new HashSet<>(Arrays.asList(visit1, visit2)));

        Collection<Visit> visits = pet.getVisits();
        assertEquals(2, visits.size(), "Expected two visits");
    }
}
