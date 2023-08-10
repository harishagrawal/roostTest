package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.samples.petclinic.visit.Visit;

public class Owner_addVisit_e85a2eeaa5_Test {

    private Owner owner;
    private Pet pet;
    private Visit visit;

    @BeforeEach
    public void setup() {
        owner = new Owner();
        pet = Mockito.mock(Pet.class);
        visit = Mockito.mock(Visit.class);

        owner.getPets().add(pet);
        Mockito.when(pet.getId()).thenReturn(1);
    }

    @Test
    public void testAddVisit_success() {
        owner.addVisit(pet.getId(), visit);
        Mockito.verify(pet, Mockito.times(1)).addVisit(visit);
    }

    @Test
    public void testAddVisit_petIdIsNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            owner.addVisit(null, visit);
        });
    }

    @Test
    public void testAddVisit_visitIsNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            owner.addVisit(pet.getId(), null);
        });
    }

    @Test
    public void testAddVisit_petNotFound() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            owner.addVisit(2, visit);
        });
    }
}
