package org.springframework.samples.petclinic.owner;

import java.util.Collection;
import java.util.LinkedHashSet;
import org.springframework.samples.petclinic.model.Visit;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class Pet_getVisits_6fe3ce5852_Test {

    @Mock
    private Pet pet;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetVisitsSuccess() {
        Visit visit1 = new Visit();
        Visit visit2 = new Visit();
        Collection<Visit> expectedVisits = new LinkedHashSet<>();
        expectedVisits.add(visit1);
        expectedVisits.add(visit2);

        when(pet.getVisits()).thenReturn(expectedVisits);
        Collection<Visit> actualVisits = pet.getVisits();

        assertEquals(expectedVisits, actualVisits);
    }

    @Test
    public void testGetVisitsWhenNoVisits() {
        Collection<Visit> expectedVisits = new LinkedHashSet<>();

        when(pet.getVisits()).thenReturn(expectedVisits);
        Collection<Visit> actualVisits = pet.getVisits();

        assertEquals(expectedVisits, actualVisits);
    }
}
