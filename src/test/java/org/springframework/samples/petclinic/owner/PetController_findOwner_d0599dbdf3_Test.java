package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.samples.petclinic.owner.Owner;
import org.springframework.samples.petclinic.owner.OwnerRepository;

import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.junit.jupiter.api.Assertions.*;

public class PetController_findOwner_d0599dbdf3_Test {

    @Mock
    private OwnerRepository owners;

    private PetController controller;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        controller = new PetController();
        controller.setOwners(owners);
    }

    @Test
    public void testFindOwner_Success() {
        Owner owner = new Owner();
        owner.setId(1);
        given(owners.findById(1)).willReturn(Optional.of(owner));

        Owner foundOwner = controller.findOwner(1);
        verify(owners).findById(1);

        assertNotNull(foundOwner, "Owner should not be null");
        assertEquals(1, foundOwner.getId().intValue(), "Owner id should be 1");
    }

    @Test
    public void testFindOwner_NotFound() {
        given(owners.findById(2)).willReturn(Optional.empty());

        Owner foundOwner = controller.findOwner(2);
        verify(owners).findById(2);

        assertNull(foundOwner, "Owner should be null");
    }
}
