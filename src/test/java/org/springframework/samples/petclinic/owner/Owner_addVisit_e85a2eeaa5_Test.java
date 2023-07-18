package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.samples.petclinic.model.Visit;
import org.springframework.samples.petclinic.model.Pet;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class Owner_addVisit_e85a2eeaa5_Test {

    @InjectMocks
    private Owner owner = new Owner();

    @Mock
    private Pet pet = new Pet();

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddVisitWithValidPetIdAndVisit() {
        Visit visit = new Visit();
        when(owner.getPet(1)).thenReturn(pet);
        owner.addVisit(1, visit);
        verify(pet, times(1)).addVisit(visit);
    }

    @Test
    public void testAddVisitWithNullPetId() {
        Visit visit = new Visit();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            owner.addVisit(null, visit);
        });
        assertEquals("Pet identifier must not be null!", exception.getMessage());
    }

    @Test
    public void testAddVisitWithNullVisit() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            owner.addVisit(1, null);
        });
        assertEquals("Visit must not be null!", exception.getMessage());
    }

    @Test
    public void testAddVisitWithInvalidPetId() {
        Visit visit = new Visit();
        when(owner.getPet(1)).thenReturn(null);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            owner.addVisit(1, visit);
        });
        assertEquals("Invalid Pet identifier!", exception.getMessage());
    }
}
