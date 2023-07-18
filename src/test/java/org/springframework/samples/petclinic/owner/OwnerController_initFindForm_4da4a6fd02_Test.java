package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OwnerController_initFindForm_4da4a6fd02_Test {

    @InjectMocks
    private OwnerController ownerController;

    public OwnerController_initFindForm_4da4a6fd02_Test() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testInitFindForm_Success() {
        String viewName = ownerController.initFindForm();
        Assertions.assertEquals("owners/findOwners", viewName, "View name should be 'owners/findOwners'");
    }

    @Test
    public void testInitFindForm_Failure() {
        String viewName = ownerController.initFindForm();
        Assertions.assertNotEquals("owners/findPets", viewName, "View name should not be 'owners/findPets'");
    }
}
