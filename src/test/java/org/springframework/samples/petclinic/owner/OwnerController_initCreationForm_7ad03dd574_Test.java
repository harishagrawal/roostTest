package org.springframework.samples.petclinic.owner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.ui.Model;

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
        String view = ownerController.initCreationForm(model);
        assertEquals("owners/createOrUpdateOwnerForm", view);
        assertEquals(new Owner(), model.get("owner"));
    }

    @Test
    public void testInitCreationFormWithExistingOwner() {
        Owner existingOwner = new Owner();
        existingOwner.setFirstName("John");
        existingOwner.setLastName("Doe");
        model.put("owner", existingOwner);

        String view = ownerController.initCreationForm(model);
        assertEquals("owners/createOrUpdateOwnerForm", view);
        assertEquals(existingOwner, model.get("owner"));
    }
}
