package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class OwnerController2_initCreationForm_7ad03dd574_Test {

    @InjectMocks
    OwnerController ownerController;

    @Mock
    Model model;

    @Test
    public void testInitCreationForm() {
        Map<String, Object> modelMap = new HashMap<>();
        String view = ownerController.initCreationForm(modelMap);

        assertEquals("owners/createOrUpdateOwnerForm", view);
        verify(model).addAttribute("owner", new Owner());
    }

    @Test
    public void testInitCreationFormWithExistingOwner() {
        Map<String, Object> modelMap = new HashMap<>();
        Owner existingOwner = new Owner();
        existingOwner.setFirstName("John");
        existingOwner.setLastName("Doe");
        modelMap.put("owner", existingOwner);

        String view = ownerController.initCreationForm(modelMap);

        assertEquals("owners/createOrUpdateOwnerForm", view);
        verify(model).addAttribute("owner", existingOwner);
    }
}
