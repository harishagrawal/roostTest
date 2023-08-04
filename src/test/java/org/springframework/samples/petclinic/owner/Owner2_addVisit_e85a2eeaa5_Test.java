package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.springframework.samples.petclinic.model.Pet;
import org.springframework.samples.petclinic.model.Visit;

public class Owner2_addVisit_e85a2eeaa5_Test {

    @Mock
    private Pet pet;

    @Mock
    private Visit visit;

    private Owner2 owner2;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        owner2 = new Owner2();
    }

    @Test
    public void testAddVisitSuccess() {
        Integer petId = 1;
        when(pet.getId()).thenReturn(petId);
        owner2.addPet(pet);
        owner2.addVisit(petId, visit);
        verify(pet).addVisit(visit);
    }

    @Test
    public void testAddVisitWithNullPetId() {
        assertThrows(IllegalArgumentException.class, () -> owner2.addVisit(null, visit));
    }

    @Test
    public void testAddVisitWithNullVisit() {
        Integer petId = 1;
        assertThrows(IllegalArgumentException.class, () -> owner2.addVisit(petId, null));
    }

    @Test
    public void testAddVisitWithInvalidPetId() {
        Integer petId = 2;
        when(pet.getId()).thenReturn(1);
        owner2.addPet(pet);
        assertThrows(IllegalArgumentException.class, () -> owner2.addVisit(petId, visit));
    }
}
