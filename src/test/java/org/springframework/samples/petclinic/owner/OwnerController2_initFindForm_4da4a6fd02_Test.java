package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class OwnerController2_initFindForm_4da4a6fd02_Test {

    @Autowired
    private OwnerController ownerController;

    @Test
    public void testInitFindFormSuccess() {
        String viewName = ownerController.initFindForm();
        assertEquals("owners/findOwners", viewName);
    }

    @Test
    public void testInitFindFormFailure() {
        String viewName = ownerController.initFindForm();
        assertEquals("owners/findOwners2", viewName);
    }
}
