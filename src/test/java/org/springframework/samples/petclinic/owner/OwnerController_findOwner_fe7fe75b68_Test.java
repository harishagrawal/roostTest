package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.samples.petclinic.owner.Owner;
import org.springframework.samples.petclinic.owner.OwnerRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;
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
    public void testFindOwner_NullId() {
        Owner owner = ownerController.findOwner(null);
        assertNotNull(owner);
    }

    @Test
    public void testFindOwner_ValidId() {
        Owner mockOwner = new Owner();
        when(owners.findById(anyInt())).thenReturn(Optional.of(mockOwner));

        Owner owner = ownerController.findOwner(1);
        assertEquals(1, owner.getId());
    }
}
