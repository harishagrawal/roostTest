package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

public class OwnerController_findOwner_fe7fe75b68_Test {

    @Mock
    private OwnerRepository owners;

    @InjectMocks
    private OwnerController controller;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindOwnerWithNullId() {
        Owner owner = controller.findOwner(null);
        assertNotNull(owner);
    }

    @Test
    public void testFindOwnerWithExistingId() {
        Integer ownerId = 1;
        Owner mockOwner = new Owner();
        mockOwner.setId(ownerId);

        when(owners.findById(ownerId)).thenReturn(java.util.Optional.of(mockOwner));

        Owner owner = controller.findOwner(ownerId);
        assertNotNull(owner);
        assertEquals(ownerId, owner.getId());
    }
}
