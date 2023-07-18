package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class OwnerController_initUpdateOwnerForm_9b9af67292_Test {

    private static final int TEST_OWNER_ID = 1;

    @Mock
    private OwnerRepository owners;

    @Mock
    private Model model;

    @InjectMocks
    private OwnerController controller;

    private Owner testOwner;

    @BeforeEach
    void setup() {
        testOwner = new Owner();
        testOwner.setId(TEST_OWNER_ID);
        when(owners.findById(TEST_OWNER_ID)).thenReturn(java.util.Optional.of(testOwner));
    }

    @Test
    void testInitUpdateOwnerForm_validOwner() {
        String view = controller.initUpdateOwnerForm(TEST_OWNER_ID, model);

        verify(model).addAttribute("owner", testOwner);
        assertEquals("owners/createOrUpdateOwnerForm", view);
    }

    @Test
    void testInitUpdateOwnerForm_invalidOwner() {
        when(owners.findById(TEST_OWNER_ID)).thenReturn(java.util.Optional.empty());

        String view = controller.initUpdateOwnerForm(TEST_OWNER_ID, model);

        verify(model).addAttribute("owner", null);
        assertEquals("owners/createOrUpdateOwnerForm", view);
    }
}
