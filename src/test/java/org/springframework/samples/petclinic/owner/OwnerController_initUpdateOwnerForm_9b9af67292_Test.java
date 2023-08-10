package org.springframework.samples.petclinic.owner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

@ExtendWith(MockitoExtension.class)
public class OwnerController_initUpdateOwnerForm_9b9af67292_Test {

    @Mock
    private OwnerRepository owners;

    @Mock
    private Model model;

    @InjectMocks
    private OwnerController controller;

    private static final String VIEWS_OWNER_CREATE_OR_UPDATE_FORM = "owners/createOrUpdateOwnerForm";
    private static final int ownerId = 1;

    @BeforeEach
    public void setup() {
        Owner owner = new Owner();
        owner.setId(ownerId);
        when(owners.findById(ownerId)).thenReturn(owner);
    }

    @Test
    public void testInitUpdateOwnerFormSuccess() {
        String view = controller.initUpdateOwnerForm(ownerId, model);
        assertEquals(VIEWS_OWNER_CREATE_OR_UPDATE_FORM, view);
    }

    @Test
    public void testInitUpdateOwnerFormFailure() {
        when(owners.findById(ownerId)).thenReturn(null);
        String view = controller.initUpdateOwnerForm(ownerId, model);
        assertEquals(VIEWS_OWNER_CREATE_OR_UPDATE_FORM, view);
    }
}
