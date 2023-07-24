package org.springframework.samples.petclinic.owner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.ui.Model;

public class OwnerController2InitCreationForm7ad03dd574Test {

    private OwnerController ownerController;
    private Map<String, Object> model;

    @BeforeEach
    public void setup() {
        ownerController = new OwnerController();
        model = new HashMap<>();
    }

    @Test
    public void testInitCreationForm() {
        String view = ownerController.initCreationForm(model);
        Owner owner = (Owner) model.get("owner");

        assertEquals("owners/createOrUpdateOwnerForm", view);
        assertEquals(new Owner(), owner);
    }

    @Test
    public void testInitCreationFormWithMockModel() {
        Model mockModel = mock(Model.class);
        
        String view = ownerController.initCreationForm(mockModel);

        verify(mockModel).addAttribute("owner", new Owner());
        assertEquals("owners/createOrUpdateOwnerForm", view);
    }
}
