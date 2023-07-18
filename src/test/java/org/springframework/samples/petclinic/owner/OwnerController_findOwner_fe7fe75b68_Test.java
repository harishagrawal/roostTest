package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

public class OwnerController_findOwner_fe7fe75b68_Test {

    @InjectMocks
    private OwnerController ownerController;

    @Mock
    private OwnerRepository owners;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindOwner_WithNullOwnerId() {
        Owner owner = ownerController.findOwner(null);
        assertNotNull(owner);
    }

    @Test
    public void testFindOwner_WithValidOwnerId() {
        int ownerId = 1;
        Owner expectedOwner = new Owner();
        expectedOwner.setId(ownerId);

        when(owners.findById(ownerId)).thenReturn(Optional.of(expectedOwner));

        Owner actualOwner = ownerController.findOwner(ownerId);
        assertEquals(expectedOwner, actualOwner);
    }
}
