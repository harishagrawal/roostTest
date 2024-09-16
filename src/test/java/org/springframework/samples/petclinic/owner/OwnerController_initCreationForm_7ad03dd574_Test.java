package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
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
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class OwnerController_initCreationForm_7ad03dd574_Test {

    @Mock
    private Model model;

    @InjectMocks
    private OwnerController ownerController;

    private Map<String, Object> testModel;

    @BeforeEach
    public void setup() {
        testModel = new HashMap<>();
    }

    @Test
    public void testInitCreationForm() {
        String viewName = ownerController.initCreationForm(model);
        assertEquals("owners/createOrUpdateOwnerForm", viewName);
        verify(model).addAttribute("owner", new Owner());
    }

    @Test
    public void testInitCreationFormWithExistingOwner() {
        Owner existingOwner = new Owner();
        existingOwner.setFirstName("John");
        existingOwner.setLastName("Doe");
        when(model.getAttribute("owner")).thenReturn(existingOwner);
        
        String viewName = ownerController.initCreationForm(model);
        assertEquals("owners/createOrUpdateOwnerForm", viewName);
        verify(model).addAttribute("owner", existingOwner);
    }

}
