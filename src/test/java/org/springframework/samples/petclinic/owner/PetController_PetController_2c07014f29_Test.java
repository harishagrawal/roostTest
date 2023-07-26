package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PetController_PetController_2c07014f29_Test {

    @Mock
    private OwnerRepository owners;

    @InjectMocks
    private PetController petController;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testPetController_WhenOwnerRepositoryIsNotNull() {
        assertNotNull(petController);
    }

    @Test
    public void testPetController_WhenOwnerRepositoryIsNull() {
        owners = null;
        assertNotNull(petController);
    }
}
