package org.springframework.samples.petclinic.owner;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.validation.BindingResult;
import org.springframework.samples.petclinic.owner.Owner;
import org.springframework.samples.petclinic.owner.OwnerRepository;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class OwnerControllerProcessUpdateOwnerFormTest {

    @InjectMocks
    private OwnerController ownerController;

    @Mock
    private OwnerRepository owners;

    @Mock
    private BindingResult result;

    @Mock
    private Owner owner;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testProcessUpdateOwnerFormSuccess() {
        when(result.hasErrors()).thenReturn(false);
        when(owners.save(any())).thenReturn(owner);
        String view = ownerController.processUpdateOwnerForm(owner, result, 1);
        assertEquals("redirect:/owners/{ownerId}", view);
        verify(owner).setId(1);
        verify(owners).save(owner);
    }

    @Test
    public void testProcessUpdateOwnerFormHasErrors() {
        when(result.hasErrors()).thenReturn(true);
        String view = ownerController.processUpdateOwnerForm(owner, result, 1);
        assertEquals("VIEWS_OWNER_CREATE_OR_UPDATE_FORM", view);
        verify(owner, never()).setId(anyInt());
        verify(owners, never()).save(any());
    }
}
