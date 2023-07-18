package org.springframework.samples.petclinic.owner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class OwnerController_OwnerController_35fab86ffa_Test {

    @Mock
    private OwnerRepository clinicService;

    @InjectMocks
    private OwnerController ownerController;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testOwnerControllerConstructor() {
        OwnerController ownerController = new OwnerController();
        assertEquals(clinicService, ownerController.getClinicService());
    }

    @Test
    public void testOwnerControllerConstructorWithNull() {
        assertThrows(NullPointerException.class, () -> {
            OwnerController ownerController = new OwnerController();
            ownerController.setClinicService(null);
        });
    }

}
