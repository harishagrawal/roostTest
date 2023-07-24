package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class OwnerController2_findOwner_fe7fe75b68_Test {

    @Mock
    private OwnerRepository owners;

    private OwnerController2 ownerController2;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        ownerController2 = new OwnerController2(owners);
    }

    @Test
    public void testFindOwner_withNullId() {
        Owner owner = ownerController2.findOwner(null);
        assertNotNull(owner);
    }

    @Test
    public void testFindOwner_withValidId() {
        Owner expectedOwner = new Owner();
        expectedOwner.setId(1);
        when(owners.findById(1)).thenReturn(java.util.Optional.of(expectedOwner));

        Owner owner = ownerController2.findOwner(1);
        assertEquals(expectedOwner, owner);
    }

    @Test
    public void testFindOwner_withInvalidId() {
        when(owners.findById(anyInt())).thenReturn(java.util.Optional.empty());

        Owner owner = ownerController2.findOwner(999);
        assertNull(owner);
    }
}
