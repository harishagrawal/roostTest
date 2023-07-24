package org.springframework.samples.petclinic.owner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.owner.OwnerRepository;

public class OwnerController_OwnerController_35fab86ffa_Test {

    private OwnerRepository ownerRepository;
    private OwnerController ownerController;

    @BeforeEach
    public void setup() {
        this.ownerRepository = mock(OwnerRepository.class);
        this.ownerController = new OwnerController();
        this.ownerController.setOwnerRepository(this.ownerRepository);
    }

    @Test
    public void testOwnerController() {
        assertEquals(this.ownerController.getOwnerRepository(), this.ownerRepository);
    }

    @Test
    public void testOwnerControllerWithNull() {
        OwnerController ownerControllerNull = new OwnerController();
        ownerControllerNull.setOwnerRepository(null);
        assertEquals(ownerControllerNull.getOwnerRepository(), null);
    }
}
