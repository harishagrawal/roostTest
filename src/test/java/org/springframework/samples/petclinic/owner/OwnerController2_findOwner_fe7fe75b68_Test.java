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

public class OwnerController2_findOwner_fe7fe75b68_Test {

    @InjectMocks
    private OwnerController ownerController;

    @Mock
    private OwnerRepository owners;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindOwner_withNullOwnerId() {
        Owner owner = ownerController.findOwner(null);
        assertNotNull(owner);
    }

    @Test
    public void testFindOwner_withValidOwnerId() {
        Integer ownerId = 1;
        Owner expectedOwner = new Owner();
        when(owners.findById(ownerId)).thenReturn(Optional.of(expectedOwner));

        Owner actualOwner = ownerController.findOwner(ownerId);
        assertEquals(expectedOwner, actualOwner);
    }

    @Test
    public void testFindOwner_withNonExistentOwnerId() {
        Integer ownerId = 100;
        when(owners.findById(ownerId)).thenReturn(Optional.empty());

        Owner owner = ownerController.findOwner(ownerId);
        assertNotNull(owner);
    }
}
