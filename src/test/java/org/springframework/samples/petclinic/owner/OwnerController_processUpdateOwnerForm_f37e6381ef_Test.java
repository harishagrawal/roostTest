package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.validation.BindingResult;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class OwnerController_processUpdateOwnerForm_f37e6381ef_Test {

    @Mock
    private OwnerRepository owners;

    @Mock
    private BindingResult result;

    @InjectMocks
    private OwnerController ownerController;

    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testProcessUpdateOwnerForm_success() {
        Owner owner = new Owner();
        owner.setId(1);
        when(result.hasErrors()).thenReturn(false);
        when(owners.save(any(Owner.class))).thenReturn(owner);

        String view = ownerController.processUpdateOwnerForm(owner, result, 1);

        verify(owners, times(1)).save(any(Owner.class));
        assertEquals("redirect:/owners/{ownerId}", view);
    }

    @Test
    void testProcessUpdateOwnerForm_failure() {
        Owner owner = new Owner();
        owner.setId(1);
        when(result.hasErrors()).thenReturn(true);

        String view = ownerController.processUpdateOwnerForm(owner, result, 1);

        verify(owners, times(0)).save(any(Owner.class));
        assertEquals("ownerCreateOrUpdateOwnerForm", view);
    }
}
