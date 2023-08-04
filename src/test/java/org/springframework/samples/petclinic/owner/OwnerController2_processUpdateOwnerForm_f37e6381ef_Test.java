package org.springframework.samples.petclinic.owner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.validation.BindingResult;

class OwnerController2_processUpdateOwnerForm_f37e6381ef_Test {

    @InjectMocks
    OwnerController ownerController = new OwnerController();

    @Mock
    OwnerRepository owners = new OwnerRepository();

    @Mock
    BindingResult result = new BindingResult();

    @Mock
    Owner owner = new Owner();

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testProcessUpdateOwnerForm_Success() {
        int ownerId = 1;
        when(result.hasErrors()).thenReturn(false);
        String view = ownerController.processUpdateOwnerForm(owner, result, ownerId);

        verify(owner).setId(ownerId);
        verify(owners).save(owner);
        assertEquals("redirect:/owners/{ownerId}", view);
    }

    @Test
    void testProcessUpdateOwnerForm_Failure() {
        int ownerId = 1;
        when(result.hasErrors()).thenReturn(true);
        String view = ownerController.processUpdateOwnerForm(owner, result, ownerId);

        assertEquals("ownerCreateOrUpdateOwnerForm", view);
    }
}
