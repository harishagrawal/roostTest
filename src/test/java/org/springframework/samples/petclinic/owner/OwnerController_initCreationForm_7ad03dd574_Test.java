package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class OwnerController_initCreationForm_7ad03dd574_Test {

    @InjectMocks
    private OwnerController ownerController;

    private Map<String, Object> model;

    @BeforeEach
    public void setup() {
        model = new HashMap<>();
    }

    @Test
    public void testInitCreationForm() {
        String view = ownerController.initCreationForm(model);

        assertEquals("owners/createOrUpdateOwnerForm", view);
        assertTrue(model.containsKey("owner"));
        assertTrue(model.get("owner") instanceof Owner);
    }

    @Test
    public void testInitCreationFormWithPreExistingOwner() {
        Owner preExistingOwner = new Owner();
        model.put("owner", preExistingOwner);

        String view = ownerController.initCreationForm(model);

        assertEquals("owners/createOrUpdateOwnerForm", view);
        assertTrue(model.containsKey("owner"));
        assertEquals(preExistingOwner, model.get("owner"));
    }
}
