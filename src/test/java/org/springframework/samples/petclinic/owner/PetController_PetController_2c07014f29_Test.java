package org.springframework.samples.petclinic.owner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class PetControllerTest {

    @Mock
    private OwnerRepository owners;

    private PetController petController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        petController = new PetController();
        petController.setOwnerRepository(owners);
    }

    @Test
    public void testPetController() {
        Owner expectedOwner = new Owner(); 

        int ownerId = 1; 

        when(owners.findById(ownerId)).thenReturn(expectedOwner);

        Owner actualOwner = petController.getOwner(ownerId);

        assertEquals(expectedOwner, actualOwner);
    }

    @Test
    public void testPetControllerWhenOwnerNotFound() {
        int ownerId = 1; 

        when(owners.findById(ownerId)).thenReturn(null);

        Owner actualOwner = petController.getOwner(ownerId);

        assertEquals(null, actualOwner);
    }
}
