package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.samples.petclinic.model.Pet;
import org.springframework.samples.petclinic.model.Visit;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class Owner_addVisit_e85a2eeaa5_Test {

    @Mock
    private Pet pet;

    @InjectMocks
    private Owner owner;

    private Visit visit;

    @BeforeEach
    public void setup() {
        visit = new Visit();
    }

    @Test
    public void testAddVisit_withValidPetAndVisit() {
        owner.addVisit(1, visit);
        verify(pet, times(1)).addVisit(visit);
    }

    @Test
    public void testAddVisit_withNullPetId() {
        assertThrows(IllegalArgumentException.class, () -> {
            owner.addVisit(null, visit);
        });
    }

    @Test
    public void testAddVisit_withNullVisit() {
        assertThrows(IllegalArgumentException.class, () -> {
            owner.addVisit(1, null);
        });
    }

    @Test
    public void testAddVisit_withInvalidPetId() {
        when(owner.getPet(2)).thenReturn(null);
        assertThrows(IllegalArgumentException.class, () -> {
            owner.addVisit(2, visit);
        });
    }
}
