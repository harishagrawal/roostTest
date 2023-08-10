package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.validation.BindingResult;
import org.springframework.samples.petclinic.owner.Owner;
import org.springframework.samples.petclinic.owner.OwnerRepository;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class OwnerController_processUpdateOwnerForm_f37e6381ef_Test {

    @Mock
    private OwnerRepository owners;

    @Mock
    private BindingResult result;

    @Mock
    private Owner owner;

    @InjectMocks
    private OwnerController controller;

    @BeforeEach
    void setup() {
        when(owner.getId()).thenReturn(1);
    }

    @Test
    void testProcessUpdateOwnerForm_Success() {
        when(result.hasErrors()).thenReturn(false);

        String view = controller.processUpdateOwnerForm(owner, result, 1);

        verify(owner, times(1)).setId(1);
        verify(owners, times(1)).save(owner);
        assertEquals("redirect:/owners/{ownerId}", view);
    }

    @Test
    void testProcessUpdateOwnerForm_Failure() {
        when(result.hasErrors()).thenReturn(true);

        String view = controller.processUpdateOwnerForm(owner, result, 1);

        verify(owner, never()).setId(anyInt());
        verify(owners, never()).save(any(Owner.class));
        assertEquals("ownerCreateOrUpdateOwnerForm", view);
    }
}
