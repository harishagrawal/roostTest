package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.validation.BindingResult;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class OwnerController2_processUpdateOwnerForm_f37e6381ef_Test {

    @InjectMocks
    OwnerController ownerController;

    @Mock
    BindingResult result;

    @Mock
    OwnerRepository owners;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testProcessUpdateOwnerForm_Success() {
        Owner owner = new Owner();
        when(result.hasErrors()).thenReturn(false);
        when(owners.save(any(Owner.class))).thenReturn(owner);

        String view = ownerController.processUpdateOwnerForm(owner, result, 1);
        assertEquals("redirect:/owners/{ownerId}", view);
    }

    @Test
    public void testProcessUpdateOwnerForm_Failure() {
        Owner owner = new Owner();
        when(result.hasErrors()).thenReturn(true);

        String view = ownerController.processUpdateOwnerForm(owner, result, 1);
        assertEquals("VIEWS_OWNER_CREATE_OR_UPDATE_FORM", view);
    }
}
