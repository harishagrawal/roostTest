package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.springframework.samples.petclinic.model.Visit;
import org.springframework.samples.petclinic.model.Pet;

public class Owner_addVisit_e85a2eeaa5_Test {

    private Owner owner;
    private Pet pet;
    private Visit visit;
    
    @BeforeEach
    public void setup() {
        owner = new Owner();
        pet = mock(Pet.class);
        visit = new Visit();
    }

    @Test
    public void testAddVisitSuccess() {
        owner.addPet(pet);
        when(pet.getId()).thenReturn(1);
        owner.addVisit(1, visit);
        // TODO: Add verification that visit was added to pet
    }

    @Test
    public void testAddVisitWithNullPetId() {
        assertThrows(IllegalArgumentException.class, () -> owner.addVisit(null, visit));
    }

    @Test
    public void testAddVisitWithNullVisit() {
        assertThrows(IllegalArgumentException.class, () -> owner.addVisit(1, null));
    }

    @Test
    public void testAddVisitWithInvalidPetId() {
        when(pet.getId()).thenReturn(1);
        assertThrows(IllegalArgumentException.class, () -> owner.addVisit(2, visit));
    }
}
