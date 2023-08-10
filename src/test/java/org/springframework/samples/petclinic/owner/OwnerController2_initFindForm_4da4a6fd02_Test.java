package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;

public class OwnerController2_initFindForm_4da4a6fd02_Test {

    @InjectMocks
    private OwnerController ownerController;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
        ownerController = new OwnerController();
    }

    @Test
    public void testInitFindForm_Success() {
        String viewName = ownerController.initFindForm(mock(Model.class));
        assertEquals("owners/findOwners", viewName);
    }

    @Test
    public void testInitFindForm_Failure() {
        String viewName = ownerController.initFindForm(mock(Model.class));
        assertNotEquals("owners/otherView", viewName);
    }
}
