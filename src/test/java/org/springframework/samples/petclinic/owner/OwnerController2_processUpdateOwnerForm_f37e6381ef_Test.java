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
    private Owner owner;

    @Mock
    private BindingResult result;

    @Mock
    private OwnerRepository owners;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testProcessUpdateOwnerForm_Success() {
        when(result.hasErrors()).thenReturn(false);
        when(owners.save(owner)).thenReturn(owner);
        String view = ownerController.processUpdateOwnerForm(owner, result, 1);
        assertEquals("redirect:/owners/1", view);
    }

    @Test
    public void testProcessUpdateOwnerForm_HasErrors() {
        when(result.hasErrors()).thenReturn(true);
        String view = ownerController.processUpdateOwnerForm(owner, result, 1);
        assertEquals("ownerCreateOrUpdateOwnerForm", view);
    }
}
