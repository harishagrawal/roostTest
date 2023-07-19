package org.springframework.samples.petclinic.owner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

public class OwnerControllerTest {

    @InjectMocks
    private OwnerController controller;

    @Mock
    private OwnerRepository owners;

    @Mock
    private Model model;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testInitUpdateOwnerForm() {
        Owner owner = new Owner();
        owner.setId(1);
        when(owners.findById(1)).thenReturn(owner);
        String viewName = controller.initUpdateOwnerForm(1, model);
        assertEquals("owners/createOrUpdateOwnerForm", viewName);
    }

    @Test
    public void testInitUpdateOwnerFormNonExistentOwner() {
        when(owners.findById(1)).thenReturn(null);
        String viewName = controller.initUpdateOwnerForm(1, model);
        assertEquals("owners/createOrUpdateOwnerForm", viewName);
    }
}
