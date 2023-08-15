package org.springframework.samples.petclinic.owner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


public class PetController_findOwner_0895b41fd2_Test {

    @InjectMocks
    private OwnerController ownerController;

    @Mock
    private OwnerRepository ownerRepository;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindOwner_success() {
        Owner owner = new Owner();
        when(ownerRepository.findById(1)).thenReturn(java.util.Optional.of(owner));

        Owner result = ownerController.findOwner(1);
        assertEquals(owner, result);
    }

    @Test
    public void testFindOwner_failure() {
        when(ownerRepository.findById(1)).thenReturn(java.util.Optional.empty());

        Owner result = ownerController.findOwner(1);
        assertNull(result);
    }
}
