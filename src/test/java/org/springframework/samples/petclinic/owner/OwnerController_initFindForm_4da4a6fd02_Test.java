package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class OwnerController_initFindForm_4da4a6fd02_Test {

    @Test
    public void testInitFindForm_Success() {
        OwnerController ownerController = new OwnerController();
        String viewName = ownerController.initFindForm();
        assertEquals("owners/findOwners", viewName);
    }

    @Test
    public void testInitFindForm_Failure() {
        OwnerController ownerController = new OwnerController();
        String viewName = ownerController.initFindForm();
        assertNotEquals("owners/findPets", viewName);
    }
}
