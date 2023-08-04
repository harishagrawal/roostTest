package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class Owner_addVisit_e85a2eeaa5_Test {

    @Test
    public void testAddVisitSuccess() {
        Integer petId = 1;
        Visit visit = mock(Visit.class);
        Pet pet = mock(Pet.class);

        Owner owner = new Owner();
        Owner spyOwner = spy(owner);

        when(spyOwner.getPet(petId)).thenReturn(pet);

        spyOwner.addVisit(petId, visit);

        verify(pet, times(1)).addVisit(visit);
    }

    @Test
    public void testAddVisitFailInvalidPetId() {
        Integer petId = null;
        Visit visit = mock(Visit.class);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Owner().addVisit(petId, visit);
        });

        String expectedMessage = "Pet identifier must not be null!";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testAddVisitFailInvalidVisit() {
        Integer petId = 1;
        Visit visit = null;

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Owner().addVisit(petId, visit);
        });

        String expectedMessage = "Visit must not be null!";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}
