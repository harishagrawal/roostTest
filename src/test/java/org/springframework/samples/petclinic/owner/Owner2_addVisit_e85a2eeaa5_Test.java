package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.samples.petclinic.model.Pet;
import org.springframework.samples.petclinic.model.Visit;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class Owner2_addVisit_e85a2eeaa5_Test {

    @Mock
    Pet pet;

    @InjectMocks
    Owner2 owner;

    @BeforeEach
    void setup() {
        owner = new Owner2();
    }

    @Test
    public void testAddVisit() {
        Visit visit = new Visit();
        owner.addVisit(1, visit);
        verify(pet, times(1)).addVisit(visit);
    }

    @Test
    public void testAddVisitWithNullPetId() {
        Visit visit = new Visit();
        assertThrows(IllegalArgumentException.class, () -> {
            owner.addVisit(null, visit);
        });
    }

    @Test
    public void testAddVisitWithNullVisit() {
        assertThrows(IllegalArgumentException.class, () -> {
            owner.addVisit(1, null);
        });
    }

    @Test
    public void testAddVisitWithInvalidPetId() {
        when(owner.getPet(1)).thenReturn(null);
        Visit visit = new Visit();
        assertThrows(IllegalArgumentException.class, () -> {
            owner.addVisit(1, visit);
        });
    }
}
