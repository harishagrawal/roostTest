package org.springframework.samples.petclinic.owner;

import java.util.ArrayList;
import java.util.Collection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.samples.petclinic.visit.Visit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class Pet_getVisits_6fe3ce5852_Test {

    @InjectMocks
    Pet pet;

    @Mock
    Collection<Visit> visits;

    @BeforeEach
    public void setup() {
        visits = new ArrayList<>();
        when(pet.getVisits()).thenReturn(visits);
    }

    @Test
    public void testGetVisitsWhenVisitsArePresent() {
        Visit visit1 = new Visit();
        Visit visit2 = new Visit();
        visits.add(visit1);
        visits.add(visit2);
        
        Collection<Visit> result = pet.getVisits();
        
        assertEquals(2, result.size());
        assertEquals(visits, result);
    }

    @Test
    public void testGetVisitsWhenNoVisits() {
        Collection<Visit> result = pet.getVisits();
        
        assertEquals(0, result.size());
        assertEquals(visits, result);
    }
}
