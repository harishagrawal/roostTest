package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.samples.petclinic.visit.Visit;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class Pet_addVisit_99c71f5c31_Test {

    Pet pet;

    @Mock
    Visit visit;

    @BeforeEach
    void setup() {
        pet = new Pet();
    }

    @Test
    public void testAddVisit() {
        pet.addVisit(visit);
        assertTrue(pet.getVisits().contains(visit));
    }

    @Test
    public void testAddVisit_NullVisit() {
        Visit nullVisit = null;
        pet.addVisit(nullVisit);
        assertTrue(pet.getVisits().isEmpty());
    }
}
