package org.springframework.samples.petclinic.owner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.validation.BindingResult;

@ExtendWith(MockitoExtension.class)
public class OwnerController_processCreationForm_9aa1f495ef_Test {

    @Mock
    private OwnerRepository owners;

    @Mock
    private BindingResult result;

    @InjectMocks
    private OwnerController ownerController;

    private Owner owner;

    @BeforeEach
    public void setup() {
        owner = new Owner();
        owner.setId(1);
    }

    @Test
    public void testProcessCreationForm_success() {
        when(result.hasErrors()).thenReturn(false);
        String view = ownerController.processCreationForm(owner, result);
        verify(owners, times(1)).save(any(Owner.class));
        assertEquals("redirect:/owners/1", view);
    }

    @Test
    public void testProcessCreationForm_failure() {
        when(result.hasErrors()).thenReturn(true);
        String view = ownerController.processCreationForm(owner, result);
        verify(owners, times(0)).save(any(Owner.class));
        assertEquals("owners/createOrUpdateOwnerForm", view);
    }
}
