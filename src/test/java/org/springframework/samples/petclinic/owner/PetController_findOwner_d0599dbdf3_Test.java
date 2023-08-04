package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PetController_findOwner_d0599dbdf3_Test {

    @InjectMocks
    PetController petController = new PetController();

    @Mock
    OwnerRepository owners;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindOwner_validId() {
        Owner owner = new Owner();
        owner.setId(1);
        when(owners.findById(1)).thenReturn(owner);

        Owner result = petController.findOwner(1);
        assertNotNull(result, "Owner should not be null");
        assertEquals(1, result.getId(), "Owner id should be 1");
    }

    @Test
    public void testFindOwner_invalidId() {
        when(owners.findById(1)).thenReturn(null);

        Owner result = petController.findOwner(1);
        assertNull(result, "Owner should be null for invalid id");
    }
}
