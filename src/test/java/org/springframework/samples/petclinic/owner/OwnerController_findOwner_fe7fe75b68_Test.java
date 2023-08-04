package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class OwnerController_findOwner_fe7fe75b68_Test {

    @Mock
    private OwnerRepository owners;

    @InjectMocks
    private OwnerController controller;

    @Test
    public void testFindOwner_NullId() {
        Owner owner = controller.findOwner(null);
        assertNotNull(owner);
        verify(owners, times(0)).findById(anyInt());
    }

    @Test
    public void testFindOwner_ValidId() {
        int ownerId = 1;
        Owner expectedOwner = new Owner();
        when(owners.findById(ownerId)).thenReturn(expectedOwner);

        Owner actualOwner = controller.findOwner(ownerId);
        assertEquals(expectedOwner, actualOwner);
        verify(owners, times(1)).findById(ownerId);
    }

    @Test
    public void testFindOwner_InvalidId() {
        int ownerId = -1;
        when(owners.findById(ownerId)).thenReturn(null);

        Owner actualOwner = controller.findOwner(ownerId);
        assertNull(actualOwner);
        verify(owners, times(1)).findById(ownerId);
    }
}
