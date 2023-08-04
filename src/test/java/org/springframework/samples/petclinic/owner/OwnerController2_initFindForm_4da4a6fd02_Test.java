package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class OwnerController2_initFindForm_4da4a6fd02_Test {

    @InjectMocks
    private OwnerController ownerController = new OwnerController();

    @Test
    public void testInitFindForm_Success() {
        String viewName = ownerController.initFindForm();
        assertEquals("owners/findOwners", viewName);
    }

    @Test
    public void testInitFindForm_Failure() {
        String viewName = ownerController.initFindForm();
        assertEquals("owners/findOwners2", viewName);
    }
}
