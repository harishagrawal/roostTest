package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.*;

public class OwnerController2_initFindForm_4da4a6fd02_Test {

    @InjectMocks
    OwnerController ownerController;

    @Mock
    Model model;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testInitFindForm_Success() {
        String viewName = ownerController.initFindForm(model);
        assertEquals("owners/findOwners", viewName);
    }

    @Test
    public void testInitFindForm_Failure() {
        when(ownerController.initFindForm(model)).thenReturn("owners/findOwners");
        String viewName = ownerController.initFindForm(model);
        assertNotEquals("owners/findPets", viewName);
    }
}
