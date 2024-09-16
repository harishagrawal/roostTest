package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class OwnerController_findOwner_fe7fe75b68_Test {
    @Mock
    private OwnerRepository owners;

    @InjectMocks
    private OwnerController controller;

    @BeforeEach
    public void setup() {
        when(owners.findById(anyInt())).thenReturn(new Owner());
    }

    @Test
    public void testFindOwner_withNullId() {
        Owner result = controller.findOwner(null);
        assertNotNull(result);
    }

    @Test
    public void testFindOwner_withId() {
        int ownerId = 1; 
        Owner result = controller.findOwner(ownerId);
        assertNotNull(result);
        verify(owners, times(1)).findById(ownerId);
    }
}
