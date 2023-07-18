package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.samples.petclinic.visit.Visit;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class Pet_addVisit_99c71f5c31_Test {

    @InjectMocks
    Pet pet;

    @Mock
    Visit visit;

    @BeforeEach
    public void setup() {
        pet = new Pet();
    }

    @Test
    public void testAddVisit_Success() {
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
