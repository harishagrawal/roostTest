package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.samples.petclinic.visit.Visit;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class Pet_getVisits_6fe3ce5852_Test {

    private Pet pet;

    @BeforeEach
    public void setup() {
        pet = new Pet();
    }

    @Test
    public void testGetVisits_whenNoVisits() {
        Collection<Visit> visits = pet.getVisits();
        assertTrue(visits.isEmpty(), "The collection should be empty as no visits are added yet.");
    }

    @Test
    public void testGetVisits_whenVisitsExist() {
        Visit visit1 = new Visit();
        Visit visit2 = new Visit();
        pet.addVisit(visit1);
        pet.addVisit(visit2);

        Collection<Visit> visits = pet.getVisits();
        assertEquals(2, visits.size(), "The collection should contain 2 visits.");
        assertTrue(visits.containsAll(Arrays.asList(visit1, visit2)), "The collection should contain all added visits.");
    }
}
