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

    @InjectMocks
    private OwnerController ownerController;

    @Mock
    private OwnerRepository owners;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindOwnerWithNullId() {
        Owner owner = ownerController.findOwner(null);
        assertNotNull(owner);
    }

    @Test
    public void testFindOwnerWithValidId() {
        Owner mockOwner = new Owner();
        mockOwner.setId(1);
        when(owners.findById(1)).thenReturn(java.util.Optional.of(mockOwner));

        Owner owner = ownerController.findOwner(1);
        assertNotNull(owner);
        assertEquals(1, owner.getId());
    }
}
