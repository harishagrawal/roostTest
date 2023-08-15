package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OwnerController2_initFindForm_d49390f8bd_Test {

    @Test
    public void testInitFindFormSuccess() {
        OwnerController controller = new OwnerController();
        String view = controller.initFindForm();
        assertEquals("owners/findOwners", view);
    }

    @Test
    public void testInitFindFormFailure() {
        OwnerController controller = new OwnerController();
        String view = controller.initFindForm();
        // This test should fail as the returned view is not "owners/findOwners1"
        assertEquals("owners/findOwners1", view);
    }
}
