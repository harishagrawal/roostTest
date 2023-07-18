package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OwnerController_initFindForm_4da4a6fd02_Test {

    @InjectMocks
    private OwnerController ownerController;

    @BeforeEach
    public void setup() {
        ownerController = new OwnerController();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testInitFindForm_Success() {
        String viewName = ownerController.initFindForm();
        assertEquals("owners/findOwners", viewName);
    }

    @Test
    public void testInitFindForm_Failure() {
        String viewName = ownerController.initFindForm();
        assertEquals("owners/notFindOwners", viewName);
    }
}
