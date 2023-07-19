package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.samples.petclinic.owner.OwnerController;
import org.springframework.samples.petclinic.owner.OwnerRepository;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

public class OwnerController_OwnerController_35fab86ffa_Test {

    private OwnerRepository ownerRepository;
    private OwnerController ownerController;

    @BeforeEach
    public void setup() {
        ownerRepository = mock(OwnerRepository.class);
        ownerController = new OwnerController();
    }

    @Test
    public void testOwnerControllerConstructor_success() {
        assertNotNull(ownerController);
    }

    @Test
    public void testOwnerControllerConstructor_failure() {
        assertThrows(Exception.class, () -> new OwnerController());
    }
}
