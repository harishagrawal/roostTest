package org.springframework.samples.petclinic.owner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

public class OwnerController_initCreationForm_7ad03dd574_Test {

    @InjectMocks
    private OwnerController ownerController;

    @Mock
    private Model model;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testInitCreationForm() {
        Owner owner = new Owner();
        when(model.addAttribute("owner", owner)).thenReturn(model);
        String view = ownerController.initCreationForm(model);
        assertEquals("owners/createOrUpdateOwnerForm", view);
        verify(model).addAttribute("owner", owner);
    }

    @Test
    public void testInitCreationFormWithNullModel() {
        String view = ownerController.initCreationForm(null);
        assertEquals("owners/createOrUpdateOwnerForm", view);
    }
}
