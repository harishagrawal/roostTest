package org.springframework.samples.petclinic.owner;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

public class OwnerController_processCreationForm_9aa1f495ef_Test {

    private OwnerController ownerController;
    private OwnerRepository owners;
    private Owner owner;
    private BindingResult result;

    @BeforeEach
    public void setup() {
        owners = mock(OwnerRepository.class);
        ownerController = new OwnerController();
        owner = new Owner();
        owner.setId(1);
        result = mock(BindingResult.class);
    }

    @Test
    public void testProcessCreationForm_success() {
        when(result.hasErrors()).thenReturn(false);
        when(owners.save(any(Owner.class))).thenReturn(owner);

        String view = ownerController.processCreationForm(owner, result);

        assertEquals("redirect:/owners/" + owner.getId(), view);
        verify(owners, times(1)).save(any(Owner.class));
    }

    @Test
    public void testProcessCreationForm_failure() {
        when(result.hasErrors()).thenReturn(true);
        when(result.getFieldError()).thenReturn(new FieldError("owner", "name", "Name required"));

        String view = ownerController.processCreationForm(owner, result);

        assertEquals("owners/createOrUpdateOwnerForm", view);
        verify(owners, times(0)).save(any(Owner.class));
    }
}
