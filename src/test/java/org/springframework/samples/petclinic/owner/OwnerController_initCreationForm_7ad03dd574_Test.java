package org.springframework.samples.petclinic.owner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OwnerController_initCreationForm_7ad03dd574_Test {

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
        assertEquals("VIEWS_OWNER_CREATE_OR_UPDATE_FORM", viewName);
        assertTrue(model.containsKey("owner"));
        assertTrue(model.get("owner") instanceof Owner);
    }

    @Test
    public void testInitCreationFormWithNullModel() {
        String viewName = ownerController.initCreationForm(null);
        assertEquals("VIEWS_OWNER_CREATE_OR_UPDATE_FORM", viewName);
    }
}
