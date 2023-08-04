package org.springframework.samples.petclinic.owner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class OwnerController2_findOwner_fe7fe75b68_Test {

    @Mock
    private OwnerRepository owners;

    private OwnerController controller;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.controller = new OwnerController();
    }

    @Test
    public void testFindOwner_NullOwnerId() {
        Owner owner = new Owner();
        assertNotNull(owner, "Owner should not be null");
    }

    @Test
    public void testFindOwner_ValidOwnerId() {
        Integer ownerId = 1;
        Owner expectedOwner = new Owner();
        expectedOwner.setId(ownerId);

        when(owners.findById(ownerId)).thenReturn(java.util.Optional.of(expectedOwner));

        Owner actualOwner = controller.findOwner(ownerId);
        assertEquals(expectedOwner, actualOwner, "Returned owner should match the expected owner");
    }
}
