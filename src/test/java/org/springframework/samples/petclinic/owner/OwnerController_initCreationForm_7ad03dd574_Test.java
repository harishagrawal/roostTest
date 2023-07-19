package org.springframework.samples.petclinic.owner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
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
    private OwnerController ownerController;

    @Mock
    private Map<String, Object> model;

    private static final String VIEWS_OWNER_CREATE_OR_UPDATE_FORM = "owners/createOrUpdateOwnerForm";

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        model = mock(Map.class);
    }

    @Test
    public void testInitCreationForm() {
        Owner owner = new Owner();
        when(model.put("owner", owner)).thenReturn(owner);
        String viewName = ownerController.initCreationForm(model);
        verify(model).put("owner", owner);
        assertEquals(VIEWS_OWNER_CREATE_OR_UPDATE_FORM, viewName);
    }

    @Test
    public void testInitCreationFormWithEmptyModel() {
        model = new HashMap<>();
        String viewName = ownerController.initCreationForm(model);
        Owner owner = (Owner) model.get("owner");
        assertEquals(owner, model.get("owner"));
        assertEquals(VIEWS_OWNER_CREATE_OR_UPDATE_FORM, viewName);
    }
}
