package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.samples.petclinic.model.Pet;
import org.springframework.samples.petclinic.model.Visit;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class Owner2_addVisit_7e29d16554_Test {

    @Mock
    private Owner2 owner2;

    @Mock
    private Pet pet;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddVisitSuccess() {
        Visit visit = new Visit();
        when(owner2.getPet(anyInt())).thenReturn(pet);
        owner2.addVisit(1, visit);
        verify(pet, times(1)).addVisit(visit);
    }

    @Test
    public void testAddVisitWithNullPetId() {
        Visit visit = new Visit();
        assertThrows(IllegalArgumentException.class, () -> owner2.addVisit(null, visit), "Pet identifier must not be null!");
    }

    @Test
    public void testAddVisitWithNullVisit() {
        assertThrows(IllegalArgumentException.class, () -> owner2.addVisit(1, null), "Visit must not be null!");
    }

    @Test
    public void testAddVisitWithInvalidPetId() {
        when(owner2.getPet(anyInt())).thenReturn(null);
        assertThrows(IllegalArgumentException.class, () -> owner2.addVisit(1, new Visit()), "Invalid Pet identifier!");
    }
}
