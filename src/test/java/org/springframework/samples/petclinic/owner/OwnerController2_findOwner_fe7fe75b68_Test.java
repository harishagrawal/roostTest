package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class OwnerController2_findOwner_fe7fe75b68_Test {

    @Mock
    private OwnerRepository owners;

    @InjectMocks
    private OwnerController ownerController;

    private Owner owner;

    @BeforeEach
    void setup() {
        owner = new Owner();
        owner.setId(1);
        when(owners.findById(1)).thenReturn(owner);
    }

    @Test
    void testFindOwnerWithNullId() {
        Owner result = ownerController.findOwner(null);
        assertNotNull(result);
        assertNull(result.getId());
    }

    @Test
    void testFindOwnerWithValidId() {
        Owner result = ownerController.findOwner(1);
        assertNotNull(result);
        assertEquals(owner.getId(), result.getId());
        verify(owners, times(1)).findById(1);
    }

    @Test
    void testFindOwnerWithInvalidId() {
        Owner result = ownerController.findOwner(2);
        assertNull(result);
        verify(owners, times(1)).findById(2);
    }
}
