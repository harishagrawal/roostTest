package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class OwnerController_initUpdateOwnerForm_9b9af67292_Test {

    @InjectMocks
    OwnerController ownerController;

    @Mock
    OwnerRepository owners;

    @Mock
    Model model;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
        ownerController = new OwnerController();
        owners = mock(OwnerRepository.class);
        model = mock(Model.class);
    }

    @Test
    public void testInitUpdateOwnerForm() {
        Owner owner = new Owner();
        owner.setId(1);
        when(owners.findById(anyInt())).thenReturn(owner);

        String viewName = ownerController.initUpdateOwnerForm(1, model);

        verify(owners, times(1)).findById(anyInt());
        verify(model, times(1)).addAttribute(any(Owner.class));
        assertEquals("owners/createOrUpdateOwnerForm", viewName);
    }

    @Test
    public void testInitUpdateOwnerForm_ownerNotFound() {
        when(owners.findById(anyInt())).thenReturn(null);

        String viewName = ownerController.initUpdateOwnerForm(1, model);

        verify(owners, times(1)).findById(anyInt());
        verify(model, never()).addAttribute(any(Owner.class));
        assertEquals("owners/createOrUpdateOwnerForm", viewName);
    }
}
