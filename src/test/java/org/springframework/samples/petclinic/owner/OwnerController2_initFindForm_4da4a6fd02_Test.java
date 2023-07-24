package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class OwnerController2_initFindForm_4da4a6fd02_Test {

    @InjectMocks
    private OwnerController ownerController = new OwnerController();

    @Mock
    private Model model;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testInitFindFormSuccess() {
        String viewName = ownerController.initFindForm(model);
        assertEquals("owners/findOwners", viewName);
    }

    @Test
    public void testInitFindFormFailure() {
        when(model.addAttribute(any(), any())).thenReturn(model);
        String viewName = ownerController.initFindForm(model);
        assertNotEquals("owners/findOwners", viewName);
    }
}
