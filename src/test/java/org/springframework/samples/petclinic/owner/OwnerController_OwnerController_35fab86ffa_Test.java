package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.samples.petclinic.owner.OwnerController;
import org.springframework.samples.petclinic.owner.OwnerRepository;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

public class OwnerController_OwnerController_35fab86ffa_Test {

    private OwnerController ownerController;
    private OwnerRepository ownerRepository;

    @BeforeEach
    public void setup() {
        ownerRepository = Mockito.mock(OwnerRepository.class);
        ownerController = new OwnerController(ownerRepository);
    }

    @Test
    public void testOwnerController() {
        Owner owner = new Owner();
        when(ownerRepository.findById(1)).thenReturn(owner);

        assertNotNull(ownerController);
    }

    @Test
    public void testOwnerControllerFailure() {
        when(ownerRepository.findById(1)).thenReturn(null);

        assertNotNull(ownerController);
    }
}
