package org.springframework.samples.petclinic.owner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.validation.BindingResult;

@ExtendWith(MockitoExtension.class)
public class OwnerController_processUpdateOwnerForm_f37e6381ef_Test {

    @InjectMocks
    private OwnerController ownerController;

    @Mock
    private OwnerRepository owners;

    @Mock
    private BindingResult result;

    @Mock
    private Owner owner;

    @Test
    public void testProcessUpdateOwnerForm_Success() {
        when(result.hasErrors()).thenReturn(false);
        String view = ownerController.processUpdateOwnerForm(owner, result, 1);
        assertEquals("redirect:/owners/1", view);
    }

    @Test
    public void testProcessUpdateOwnerForm_ValidationError() {
        when(result.hasErrors()).thenReturn(true);
        String view = ownerController.processUpdateOwnerForm(owner, result, 1);
        assertEquals("owners/createOrUpdateOwnerForm", view);
    }

}
