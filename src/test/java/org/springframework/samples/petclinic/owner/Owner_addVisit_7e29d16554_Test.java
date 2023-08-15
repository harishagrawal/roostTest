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
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class Owner_addVisit_7e29d16554_Test {

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
    public void testAddVisit() {
        doNothing().when(pet).addVisit(any(Visit.class));
        owner.addVisit(1, visit);
        verify(pet, times(1)).addVisit(visit);
    }

    @Test
    public void testAddVisitWithNullPetId() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            owner.addVisit(null, visit);
        });

        String expectedMessage = "Pet identifier must not be null!";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testAddVisitWithNullVisit() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            owner.addVisit(1, null);
        });

        String expectedMessage = "Visit must not be null!";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testAddVisitWithInvalidPetId() {
        when(owner.getPet(2)).thenReturn(null);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            owner.addVisit(2, visit);
        });

        String expectedMessage = "Invalid Pet identifier!";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}
