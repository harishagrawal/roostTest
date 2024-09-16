package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.samples.petclinic.model.Pet;
import org.springframework.samples.petclinic.model.Visit;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class Owner_addVisit_e85a2eeaa5_Test {

    @Mock
    private Pet pet;

    @InjectMocks
    private Owner owner;

    @BeforeEach
    public void setup() {
        owner.setPetsInternal(new HashSet<>());
        owner.getPetsInternal().add(pet);
    }

    @Test
    public void testAddVisitWithValidPetIdAndVisit() {
        Visit visit = new Visit();
        when(pet.getId()).thenReturn(1);

        owner.addVisit(1, visit);

        verify(pet, times(1)).addVisit(visit);
    }

    @Test
    public void testAddVisitWithNullPetId() {
        Visit visit = new Visit();

        assertThrows(IllegalArgumentException.class, () -> owner.addVisit(null, visit));
    }

    @Test
    public void testAddVisitWithNullVisit() {
        when(pet.getId()).thenReturn(1);

        assertThrows(IllegalArgumentException.class, () -> owner.addVisit(1, null));
    }

    @Test
    public void testAddVisitWithInvalidPetId() {
        Visit visit = new Visit();
        when(pet.getId()).thenReturn(2);

        assertThrows(IllegalArgumentException.class, () -> owner.addVisit(1, visit));
    }
}
