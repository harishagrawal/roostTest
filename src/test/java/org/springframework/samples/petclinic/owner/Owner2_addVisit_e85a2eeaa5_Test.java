package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.samples.petclinic.model.Pet;
import org.springframework.samples.petclinic.model.Visit;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class Owner2_addVisit_e85a2eeaa5_Test {

    @Mock
    private Pet pet;

    private Owner2 owner;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        owner = new Owner2();
    }

    @Test
    public void testAddVisitSuccess() {
        Integer petId = 1;
        Visit visit = new Visit();
        when(pet.getId()).thenReturn(petId);
        owner.addPet(pet);

        owner.addVisit(petId, visit);

        verify(pet, times(1)).addVisit(visit);
    }

    @Test
    public void testAddVisitWithNullPetId() {
        assertThrows(IllegalArgumentException.class, () -> {
            owner.addVisit(null, new Visit());
        });
    }

    @Test
    public void testAddVisitWithNullVisit() {
        Integer petId = 1;
        when(pet.getId()).thenReturn(petId);
        owner.addPet(pet);

        assertThrows(IllegalArgumentException.class, () -> {
            owner.addVisit(petId, null);
        });
    }

    @Test
    public void testAddVisitWithInvalidPetId() {
        Integer petId = 1;
        when(pet.getId()).thenReturn(petId);

        assertThrows(IllegalArgumentException.class, () -> {
            owner.addVisit(2, new Visit());
        });
    }
}
