package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OwnerController2_initCreationForm_7ad03dd574_Test {

    private OwnerController ownerController;

    @Mock
    private Model model;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        ownerController = new OwnerController();
    }

    @Test
    public void testInitCreationForm_Success() {
        Map<String, Object> model = new HashMap<>();
        String view = ownerController.initCreationForm(model);
        assertEquals("owners/createOrUpdateOwnerForm", view);
        assertTrue(model.containsKey("owner"));
        assertTrue(model.get("owner") instanceof Owner);
    }

    @Test
    public void testInitCreationForm_Failure() {
        Map<String, Object> model = null;
        try {
            ownerController.initCreationForm(model);
        } catch (NullPointerException e) {
            assertEquals("Model must not be null", e.getMessage());
        }
    }
}
