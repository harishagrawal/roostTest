package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.validation.BindingResult;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class OwnerController_processUpdateOwnerForm_f37e6381ef_Test {

    @InjectMocks
    private OwnerController ownerController = new OwnerController();

    @Mock
    private OwnerRepository owners = new OwnerRepository();

    @Mock
    private BindingResult result = new BindingResult();

    @Mock
    private Owner owner = new Owner();

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testProcessUpdateOwnerForm_Success() {
        when(result.hasErrors()).thenReturn(false);
        when(owner.getId()).thenReturn(1);
        String view = ownerController.processUpdateOwnerForm(owner, result, 1);
        assertEquals("redirect:/owners/{ownerId}", view);
        verify(owners, times(1)).save(owner);
    }

    @Test
    public void testProcessUpdateOwnerForm_Failure() {
        when(result.hasErrors()).thenReturn(true);
        String view = ownerController.processUpdateOwnerForm(owner, result, 1);
        assertEquals("VIEWS_OWNER_CREATE_OR_UPDATE_FORM", view);
        verify(owners, times(0)).save(owner);
    }
}
