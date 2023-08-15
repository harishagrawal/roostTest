package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.validation.BindingResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class OwnerController2_processUpdateOwnerForm_a228651f5b_Test {

    @InjectMocks
    OwnerController ownerController = new OwnerController();

    @Mock
    OwnerRepository owners;

    @Mock
    BindingResult result;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testProcessUpdateOwnerForm_success() {
        Owner owner = new Owner();
        owner.setId(1);
        when(result.hasErrors()).thenReturn(false);
        assertEquals("redirect:/owners/{ownerId}", ownerController.processUpdateOwnerForm(owner, result, 1));
        verify(owners, times(1)).save(owner);
    }

    @Test
    public void testProcessUpdateOwnerForm_failure() {
        Owner owner = new Owner();
        owner.setId(1);
        when(result.hasErrors()).thenReturn(true);
        assertEquals("createOrUpdateOwnerForm", ownerController.processUpdateOwnerForm(owner, result, 1));
        verify(owners, times(0)).save(owner);
    }
}
