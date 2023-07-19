package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.validation.BindingResult;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class OwnerController_processCreationForm_9aa1f495ef_Test {

    @InjectMocks
    private OwnerController ownerController;

    @Mock
    private OwnerRepository owners;

    @Mock
    private BindingResult result;

    @Test
    public void testProcessCreationForm_Success() {
        Owner owner = new Owner();
        owner.setId(1);

        when(result.hasErrors()).thenReturn(false);
        when(owners.save(owner)).thenReturn(owner);

        String view = ownerController.processCreationForm(owner, result);

        assertEquals("redirect:/owners/1", view);
    }

    @Test
    public void testProcessCreationForm_HasErrors() {
        Owner owner = new Owner();
        owner.setId(1);

        when(result.hasErrors()).thenReturn(true);

        String view = ownerController.processCreationForm(owner, result);

        assertEquals("owners/createOrUpdateOwnerForm", view);
    }
}
