package org.springframework.samples.petclinic.owner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class OwnerController_findOwner_fe7fe75b68_Test {

    @InjectMocks
    private OwnerController ownerController;

    @Mock
    private OwnerRepository owners;

    private Owner owner;

    @BeforeEach
    void setup() {
        owner = new Owner();
        owner.setId(1);
    }

    @Test
    public void testFindOwner_withNullOwnerId() {
        Owner result = ownerController.findOwner(null);
        assertNotNull(result);
        assertNull(result.getId());
    }

    @Test
    public void testFindOwner_withValidOwnerId() {
        when(owners.findById(1)).thenReturn(java.util.Optional.of(owner));
        Owner result = ownerController.findOwner(1);
        assertNotNull(result);
        assertEquals(owner.getId(), result.getId());
    }

    @Test
    public void testFindOwner_withInvalidOwnerId() {
        when(owners.findById(anyInt())).thenReturn(java.util.Optional.empty());
        Owner result = ownerController.findOwner(999);
        assertNull(result);
    }
}
