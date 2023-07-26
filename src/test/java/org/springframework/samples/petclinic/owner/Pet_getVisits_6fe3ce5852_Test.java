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
        pet = new Pet();
    }

    @Test
    public void testGetVisits_ReturnsEmptyCollection_WhenNoVisits() {
        Collection<Visit> visits = pet.getVisits();
        assertEquals(0, visits.size(), "Expected no visits but found " + visits.size());
    }

    @Test
    public void testGetVisits_ReturnsCollectionOfVisits_WhenVisitsExist() {
        Visit visit1 = mock(Visit.class);
        Visit visit2 = mock(Visit.class);

        pet.addVisit(visit1);
        pet.addVisit(visit2);

        Collection<Visit> visits = pet.getVisits();

        assertEquals(2, visits.size(), "Expected 2 visits but found " + visits.size());
        assertEquals(true, visits.containsAll(Arrays.asList(visit1, visit2)), "Returned visits do not match expected visits");
    }
}
