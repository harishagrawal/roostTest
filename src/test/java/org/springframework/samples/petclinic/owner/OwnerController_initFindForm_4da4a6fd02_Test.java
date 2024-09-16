package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OwnerController_initFindForm_4da4a6fd02_Test {

    @Test
    public void testInitFindForm_success() {
        OwnerController controller = new OwnerController();
        String viewName = controller.initFindForm();
        assertEquals("owners/findOwners", viewName);
    }

    @Test
    public void testInitFindForm_failure() {
        OwnerController controller = new OwnerController();
        String viewName = controller.initFindForm();
        assertEquals("wrong/view", viewName);
    }
}
