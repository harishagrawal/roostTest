package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

public class OwnerController2_findOwner_66dfd5ad88_Test {

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
        Owner result = ownerController.findOwner(null);
        assertNotNull(result);
    }

    @Test
    public void testFindOwnerWithId() {
        Owner owner = new Owner();
        when(owners.findById(1)).thenReturn(java.util.Optional.of(owner));
        Owner result = ownerController.findOwner(1);
        assertEquals(owner, result);
    }
}
