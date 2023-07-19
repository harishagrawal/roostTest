package org.springframework.samples.petclinic.owner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

public class OwnerController_initUpdateOwnerForm_9b9af67292_Test {

    @Mock
    private OwnerRepository owners;
    
    @Mock
    private Model model;
    
    private OwnerController ownerController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        ownerController = new OwnerController();
    }

    @Test
    public void testInitUpdateOwnerForm_success() {
        Owner owner = new Owner();
        owner.setId(1);
        when(owners.findById(1)).thenReturn(owner);

        String view = ownerController.initUpdateOwnerForm(1, model);
        assertEquals("owners/createOrUpdateOwnerForm", view);
    }

    @Test
    public void testInitUpdateOwnerForm_ownerNotFound() {
        when(owners.findById(1)).thenReturn(null);

        String view = ownerController.initUpdateOwnerForm(1, model);
        assertEquals("redirect:/oups", view);
    }
}
