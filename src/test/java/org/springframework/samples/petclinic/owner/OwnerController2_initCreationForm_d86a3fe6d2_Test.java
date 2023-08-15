package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class OwnerController2_initCreationForm_d86a3fe6d2_Test {

    @InjectMocks
    private OwnerController ownerController;

    @Mock
    private Model model;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testInitCreationForm() {
        Map<String, Object> modelMap = new HashMap<>();
        String viewName = ownerController.initCreationForm(modelMap);

        assertEquals("owners/createOrUpdateOwnerForm", viewName);
        assertEquals(new Owner().getId(), ((Owner)modelMap.get("owner")).getId());
    }

    @Test
    public void testInitCreationFormWithEmptyModel() {
        Map<String, Object> modelMap = new HashMap<>();
        when(model.asMap()).thenReturn(modelMap);

        String viewName = ownerController.initCreationForm(modelMap);
        assertEquals("owners/createOrUpdateOwnerForm", viewName);
        assertEquals(new Owner().getId(), ((Owner)modelMap.get("owner")).getId());
    }
}
