package org.springframework.samples.petclinic.owner;

import static org.mockito.Mockito.mock;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.owner.OwnerRepository;
import org.springframework.samples.petclinic.owner.OwnerController;

public class OwnerController_OwnerController_35fab86ffa_Test {

    private OwnerRepository ownerRepository;
    private OwnerController ownerController;

    @BeforeEach
    public void setup() {
        ownerRepository = mock(OwnerRepository.class);
        ownerController = new OwnerController(ownerRepository);
    }

    @Test
    public void testOwnerController() {
        // TODO: Replace with a valid ownerRepository
        when(ownerRepository.findById(1)).thenReturn(null);

        OwnerController testOwnerController = new OwnerController(ownerRepository);

        assertEquals(ownerController, testOwnerController);
    }

    @Test
    public void testOwnerControllerFailure() {
        // TODO: Replace with a valid ownerRepository
        when(ownerRepository.findById(1)).thenReturn(null);

        OwnerController testOwnerController = new OwnerController(ownerRepository);

        assertEquals(ownerController, testOwnerController);
    }

}
