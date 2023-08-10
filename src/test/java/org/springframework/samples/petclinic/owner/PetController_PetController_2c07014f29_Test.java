package org.springframework.samples.petclinic.owner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PetControllerTest {

    private OwnerRepository owners;
    private PetController petController;

    @BeforeEach
    public void setup() {
        owners = mock(OwnerRepository.class);
        petController = new PetController();
    }

    @Test
    public void testPetController_WithValidOwnerRepository() {
        when(owners.findById(1)).thenReturn(new Owner());
        petController.setOwnerRepository(owners);
        assertEquals(owners, petController.getOwnerRepository());
    }

    @Test
    public void testPetController_WithNullOwnerRepository() {
        PetController petControllerNull = new PetController();
        petControllerNull.setOwnerRepository(null);
        assertEquals(null, petControllerNull.getOwnerRepository());
    }
}
