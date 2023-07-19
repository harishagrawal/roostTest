package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.samples.petclinic.visit.Visit;

import java.util.LinkedHashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class Pet_addVisit_99c71f5c31_Test {

    @Mock
    private Pet pet;

    @Mock
    private Visit visit;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddVisit_Success() {
        Set<Visit> visits = new LinkedHashSet<>();
        when(pet.getVisits()).thenReturn(visits);

        pet.addVisit(visit);

        assertTrue(visits.contains(visit));
        verify(pet).getVisits();
    }

    @Test
    public void testAddVisit_NullVisit() {
        Set<Visit> visits = new LinkedHashSet<>();
        when(pet.getVisits()).thenReturn(visits);

        pet.addVisit(null);

        assertFalse(visits.contains(null));
        verify(pet).getVisits();
    }
}
