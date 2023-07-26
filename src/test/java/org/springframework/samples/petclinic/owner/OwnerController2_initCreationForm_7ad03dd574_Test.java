package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

public class OwnerController2_initCreationForm_7ad03dd574_Test {

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

        assertEquals("owners/createOrUpdateOwnerForm", view);
        assertTrue(modelMap.containsKey("owner"));
    }

    @Test
    public void testInitCreationForm_Failure() {
        Owner owner = new Owner();
        when(model.addAttribute("owner", owner)).thenThrow(new RuntimeException());

        Map<String, Object> modelMap = new HashMap<>();
        String view = ownerController.initCreationForm(modelMap);

        assertEquals("owners/createOrUpdateOwnerForm", view);
        assertTrue(modelMap.containsKey("owner"));
    }
}
