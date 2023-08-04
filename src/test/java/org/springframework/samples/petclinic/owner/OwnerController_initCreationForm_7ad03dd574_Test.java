package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class OwnerController_initCreationForm_7ad03dd574_Test {

    @Mock
    BindingResult result;

    @Mock
    Model model;

    @InjectMocks
    OwnerController controller;

    private Map<String, Object> modelMap;
    private Owner owner;

    @BeforeEach
    public void setup() {
        modelMap = new HashMap<>();
        owner = new Owner();
    }

    @Test
    public void testInitCreationForm_Success() {
        String view = controller.initCreationForm(owner, result, model);
        assertEquals("owners/createOrUpdateOwnerForm", view);
        verify(model).addAttribute("owner", owner);
    }

    @Test
    public void testInitCreationForm_Failure() {
        when(result.hasErrors()).thenReturn(true);
        String view = controller.initCreationForm(owner, result, model);
        assertEquals("owners/createOrUpdateOwnerForm", view);
        verify(model).addAttribute("owner", owner);
    }
}
