package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class Pet_addVisit_f1d5eb0dda_Test {

    private Pet pet;
    private Visit visit;

    @BeforeEach
    public void setup() {
        pet = new Pet();
        visit = Mockito.mock(Visit.class);
    }

    @Test
    public void testAddVisit_Success() {
        pet.addVisit(visit);
        assertTrue(pet.getVisits().contains(visit));
    }

    @Test
    public void testAddVisit_Failure() {
        assertFalse(pet.getVisits().contains(visit));
    }
}
