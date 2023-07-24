package org.springframework.samples.petclinic.owner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.ui.Model;

public class OwnerController_initCreationForm_7ad03dd574_Test {
    
    private static final String VIEWS_OWNER_CREATE_OR_UPDATE_FORM = "owners/createOrUpdateOwnerForm";
    private OwnerController ownerController;
    private Map<String, Object> model;

    @BeforeEach
    public void setup() {
        ownerController = new OwnerController();
        model = new HashMap<>();
    }

    @Test
    public void testInitCreationForm() {
        String viewName = ownerController.initCreationForm(model);
        assertEquals(VIEWS_OWNER_CREATE_OR_UPDATE_FORM, viewName, "View name should be 'owners/createOrUpdateOwnerForm'");
        Owner owner = (Owner) model.get("owner");
        assertEquals(new Owner(), owner, "Model should contain an Owner object");
    }

    @Test
    public void testInitCreationFormWithMockModel() {
        Model mockModel = mock(Model.class);
        String viewName = ownerController.initCreationForm(mockModel);
        assertEquals(VIEWS_OWNER_CREATE_OR_UPDATE_FORM, viewName, "View name should be 'owners/createOrUpdateOwnerForm'");
        verify(mockModel).addAttribute("owner", new Owner());
    }
}
