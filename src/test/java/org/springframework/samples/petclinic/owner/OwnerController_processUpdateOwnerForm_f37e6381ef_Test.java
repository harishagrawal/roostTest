package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.validation.BindingResult;
import org.springframework.samples.petclinic.owner.Owner;
import org.springframework.samples.petclinic.owner.OwnerRepository;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class OwnerController_processUpdateOwnerForm_f37e6381ef_Test {

    @InjectMocks
    OwnerController ownerController;

    @Mock
    OwnerRepository owners;

    @Mock
    BindingResult result;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testProcessUpdateOwnerFormSuccess() {
        Owner owner = new Owner();
        when(result.hasErrors()).thenReturn(false);
        when(owners.save(any(Owner.class))).thenReturn(owner);

        String view = ownerController.processUpdateOwnerForm(owner, result, 1);
        assertEquals("redirect:/owners/{ownerId}", view);
    }

    @Test
    void testProcessUpdateOwnerFormFailure() {
        Owner owner = new Owner();
        when(result.hasErrors()).thenReturn(true);

        String view = ownerController.processUpdateOwnerForm(owner, result, 1);
        assertEquals("createOrUpdateOwnerForm", view);
    }
}
