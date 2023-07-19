package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class OwnerController2_processCreationForm_9aa1f495ef_Test {

    @Mock
    private OwnerRepository owners;

    @Mock
    private BindingResult result;

    @Mock
    private Owner owner;

    private OwnerController ownerController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        ownerController = new OwnerController(owners);
    }

    @Test
    public void testProcessCreationFormWithErrors() {
        when(result.hasErrors()).thenReturn(true);
        String view = ownerController.processCreationForm(owner, result);
        assertEquals("owners/createOrUpdateOwnerForm", view);
    }

    @Test
    public void testProcessCreationFormWithoutErrors() {
        when(result.hasErrors()).thenReturn(false);
        when(owner.getId()).thenReturn(1);
        String view = ownerController.processCreationForm(owner, result);
        assertEquals("redirect:/owners/1", view);
    }
}
