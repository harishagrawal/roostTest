package org.springframework.samples.petclinic.owner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

public class OwnerController_initCreationForm_7ad03dd574_Test {

    @InjectMocks
    OwnerController ownerController;

    @Mock
    Model model;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testInitCreationForm() {
        Map<String, Object> modelMap = new HashMap<>();
        String view = ownerController.initCreationForm(modelMap);

        Owner owner = (Owner) modelMap.get("owner");

        assertEquals("owners/createOrUpdateOwnerForm", view);
        assertEquals(new Owner(), owner);
    }

    @Test
    public void testInitCreationFormWithMockModel() {
        Map<String, Object> modelMap = new HashMap<>();
        when(model.asMap()).thenReturn(modelMap);

        String view = ownerController.initCreationForm(modelMap);

        Owner owner = (Owner) modelMap.get("owner");

        assertEquals("owners/createOrUpdateOwnerForm", view);
        assertEquals(new Owner(), owner);
    }
}
