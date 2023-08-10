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
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class Owner2_addVisit_e85a2eeaa5_Test {

    @Mock
    private Pet pet;

    @InjectMocks
    private Owner2 owner2;

    @BeforeEach
    public void setup() {
        when(pet.getId()).thenReturn(1);
    }

    @Test
    public void testAddVisitWithValidPetIdAndVisit() {
        Visit visit = new Visit();
        owner2.addVisit(1, visit);
        verify(pet).addVisit(any(Visit.class));
    }

    @Test
    public void testAddVisitWithInvalidPetId() {
        assertThrows(IllegalArgumentException.class, () -> owner2.addVisit(null, new Visit()));
    }

    @Test
    public void testAddVisitWithInvalidVisit() {
        assertThrows(IllegalArgumentException.class, () -> owner2.addVisit(1, null));
    }
}
