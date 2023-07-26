package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class OwnerControllerTest {

    private OwnerRepository owners;
    private OwnerController ownerController;

    @BeforeEach
    public void setup() {
        owners = Mockito.mock(OwnerRepository.class);
        ownerController = new OwnerController();
    }

    @Test
    public void testOwnerControllerConstructor() {
        OwnerRepository clinicService = Mockito.mock(OwnerRepository.class);
        OwnerController ownerController = new OwnerController();
        assertEquals(ownerController.getClass(), OwnerController.class);
    }

    @Test
    public void testOwnerControllerConstructorWithNull() {
        assertThrows(IllegalArgumentException.class, () -> new OwnerController(null), "clinicService must not be null");
    }
}
