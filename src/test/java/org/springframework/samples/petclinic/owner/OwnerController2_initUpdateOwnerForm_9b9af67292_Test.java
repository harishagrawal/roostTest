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
public class OwnerController2_initUpdateOwnerForm_9b9af67292_Test {

    @Mock
    private OwnerRepository owners;

    @Mock
    private Model model;

    @InjectMocks
    private OwnerController controller;

    private static final String VIEWS_OWNER_CREATE_OR_UPDATE_FORM = "owners/createOrUpdateOwnerForm";
    private Owner owner;

    @BeforeEach
    public void setup() {
        owner = new Owner();
        owner.setId(1);
    }

    @Test
    public void testInitUpdateOwnerForm_success() {
        when(owners.findById(1)).thenReturn(owner);

        String viewName = controller.initUpdateOwnerForm(1, model);

        assertEquals(VIEWS_OWNER_CREATE_OR_UPDATE_FORM, viewName);
    }

    @Test
    public void testInitUpdateOwnerForm_ownerNotFound() {
        when(owners.findById(1)).thenReturn(null);

        String viewName = controller.initUpdateOwnerForm(1, model);

        assertEquals(VIEWS_OWNER_CREATE_OR_UPDATE_FORM, viewName);
    }
}
