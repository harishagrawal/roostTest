package org.springframework.samples.petclinic.owner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class OwnerController_OwnerController_8b45ad788c_Test {

    @Mock
    OwnerRepository clinicService;

    @InjectMocks
    OwnerController ownerController;

    @BeforeEach
    void setUp() {
        ownerController = new OwnerController();
    }

    @Test
    public void testOwnerControllerCreation() {
        OwnerController testOwnerController = new OwnerController();
        assertEquals(testOwnerController, ownerController);
    }

    @Test
    public void testOwnerControllerCreationFailure() {
        OwnerController testOwnerController = new OwnerController();
        assertNotEquals(testOwnerController, null);
    }
}
