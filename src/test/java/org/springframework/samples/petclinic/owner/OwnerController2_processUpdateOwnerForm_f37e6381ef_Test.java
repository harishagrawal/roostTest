package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.validation.BindingResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class OwnerController2_processUpdateOwnerForm_f37e6381ef_Test {

    @InjectMocks
    private OwnerController ownerController;

    @Mock
    private OwnerRepository owners;

    @Mock
    private BindingResult result;

    @Mock
    private Owner owner;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testProcessUpdateOwnerForm_success() {
        int ownerId = 1;
        when(result.hasErrors()).thenReturn(false);
        when(owners.save(owner)).thenReturn(owner);
        String view = ownerController.processUpdateOwnerForm(owner, result, ownerId);
        assertEquals("redirect:/owners/{ownerId}", view);
    }

    @Test
    public void testProcessUpdateOwnerForm_failure() {
        int ownerId = 1;
        when(result.hasErrors()).thenReturn(true);
        String view = ownerController.processUpdateOwnerForm(owner, result, ownerId);
        assertEquals("ownerCreateOrUpdateOwnerForm", view);
    }
}
