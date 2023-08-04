package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.validation.BindingResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class OwnerController2_processCreationForm_9aa1f495ef_Test {

    @InjectMocks
    private OwnerController ownerController = new OwnerController();

    @Mock
    private OwnerRepository owners = new OwnerRepository();

    @Mock
    private BindingResult result = new BindingResult();

    @Mock
    private Owner owner = new Owner();

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testProcessCreationFormSuccess() {
        when(result.hasErrors()).thenReturn(false);
        when(owner.getId()).thenReturn(1);

        String viewName = ownerController.processCreationForm(owner, result);

        verify(owners).save(owner);
        assertEquals("redirect:/owners/1", viewName);
    }

    @Test
    void testProcessCreationFormHasErrors() {
        when(result.hasErrors()).thenReturn(true);

        String viewName = ownerController.processCreationForm(owner, result);

        assertEquals("owners/createOrUpdateOwnerForm", viewName);
    }
}
