package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.validation.BindingResult;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class OwnerController_processUpdateOwnerForm_a228651f5b_Test {

    @InjectMocks
    OwnerController ownerController;

    @Mock
    OwnerRepository owners;

    @Mock
    BindingResult result;

    @Mock
    Owner owner;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        ownerController = new OwnerController();
        owners = mock(OwnerRepository.class);
        result = mock(BindingResult.class);
        owner = mock(Owner.class);
    }

    @Test
    void testProcessUpdateOwnerForm_Success() {
        when(result.hasErrors()).thenReturn(false);
        when(owner.getId()).thenReturn(1);

        String view = ownerController.processUpdateOwnerForm(owner, result, 1);

        verify(owners, times(1)).save(owner);
        assertEquals("redirect:/owners/{ownerId}", view);
    }

    @Test
    void testProcessUpdateOwnerForm_Failure() {
        when(result.hasErrors()).thenReturn(true);

        String view = ownerController.processUpdateOwnerForm(owner, result, 1);

        verify(owners, times(0)).save(owner);
        assertEquals("ownerCreateOrUpdateOwnerForm", view);
    }
}
