package org.springframework.samples.petclinic.owner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

public class OwnerController_initUpdateOwnerForm_5166028c6b_Test {

    @InjectMocks
    OwnerController ownerController = new OwnerController();

    @Mock
    private OwnerRepository owners;

    @Mock
    private Model model;

    private static final String VIEWS_OWNER_CREATE_OR_UPDATE_FORM = "owners/createOrUpdateOwnerForm";

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testInitUpdateOwnerForm_ExistingOwner() {
        int ownerId = 1;
        Owner owner = new Owner();
        owner.setId(ownerId);

        when(owners.findById(ownerId)).thenReturn(java.util.Optional.of(owner));

        String view = ownerController.initUpdateOwnerForm(ownerId, model);

        assertEquals(VIEWS_OWNER_CREATE_OR_UPDATE_FORM, view);
    }

    @Test
    public void testInitUpdateOwnerForm_NonExistingOwner() {
        int ownerId = 1;

        when(owners.findById(ownerId)).thenReturn(java.util.Optional.empty());

        String view = ownerController.initUpdateOwnerForm(ownerId, model);

        assertEquals(VIEWS_OWNER_CREATE_OR_UPDATE_FORM, view);
    }
}
