package org.springframework.samples.petclinic.owner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
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

    private Owner owner;

    @BeforeEach
    public void setup() {
        owner = new Owner();
        owner.setId(1);
    }

    @Test
    public void testInitUpdateOwnerForm_success() {
        when(owners.findById(1)).thenReturn(owner);

        String view = controller.initUpdateOwnerForm(1, model);

        verify(model).addAttribute("owner", owner);
        assertEquals("owners/createOrUpdateOwnerForm", view);
    }

    @Test
    public void testInitUpdateOwnerForm_ownerNotFound() {
        when(owners.findById(1)).thenReturn(null);

        String view = controller.initUpdateOwnerForm(1, model);

        verify(model).addAttribute("owner", null);
        assertEquals("owners/createOrUpdateOwnerForm", view);
    }
}
