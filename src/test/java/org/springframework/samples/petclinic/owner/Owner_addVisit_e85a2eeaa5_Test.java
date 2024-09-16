package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.samples.petclinic.model.Visit;
import org.springframework.samples.petclinic.model.Pet;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class Owner_addVisit_e85a2eeaa5_Test {

    private Owner owner;
    private Pet petMock;
    private Visit visitMock;

    @BeforeEach
    public void setup() {
        owner = new Owner();
        petMock = Mockito.mock(Pet.class);
        visitMock = Mockito.mock(Visit.class);
    }

    @Test
    public void testAddVisit() {
        Integer petId = 1;

        when(petMock.getId()).thenReturn(petId);
        owner.addPet(petMock);

        owner.addVisit(petId, visitMock);
        verify(petMock).addVisit(visitMock);
    }

    @Test
    public void testAddVisitWithInvalidPetId() {
        Integer petId = 1;
        Integer invalidPetId = 2;

        when(petMock.getId()).thenReturn(petId);
        owner.addPet(petMock);

        assertThrows(IllegalArgumentException.class, () -> owner.addVisit(invalidPetId, visitMock));
    }

    @Test
    public void testAddVisitWithNullPetId() {
        assertThrows(IllegalArgumentException.class, () -> owner.addVisit(null, visitMock));
    }

    @Test
    public void testAddVisitWithNullVisit() {
        Integer petId = 1;

        when(petMock.getId()).thenReturn(petId);
        owner.addPet(petMock);

        assertThrows(IllegalArgumentException.class, () -> owner.addVisit(petId, null));
    }
}
