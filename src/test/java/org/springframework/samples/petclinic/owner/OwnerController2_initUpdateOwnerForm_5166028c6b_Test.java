package org.springframework.samples.petclinic.owner;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.ui.Model;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OwnerController2_initUpdateOwnerForm_5166028c6b_Test {

    @Autowired
    private OwnerController ownerController;

    @MockBean
    private OwnerRepository owners;

    @MockBean
    private Model model;

    private static final int OWNER_ID = 1; 

    @Before
    public void setup() {
        Owner owner = new Owner();
        owner.setId(OWNER_ID);
        when(owners.findById(OWNER_ID)).thenReturn(java.util.Optional.of(owner));
    }

    @Test
    public void testInitUpdateOwnerForm_Success() {
        String viewName = ownerController.initUpdateOwnerForm(OWNER_ID, model);
        assertEquals("owners/createOrUpdateOwnerForm", viewName);
        verify(owners, times(1)).findById(OWNER_ID);
        verify(model, times(1)).addAttribute(any(Owner.class));
    }

    @Test
    public void testInitUpdateOwnerForm_OwnerNotFound() {
        when(owners.findById(OWNER_ID)).thenReturn(java.util.Optional.empty());
        String viewName = ownerController.initUpdateOwnerForm(OWNER_ID, model);
        assertEquals("owners/createOrUpdateOwnerForm", viewName);
        verify(owners, times(1)).findById(OWNER_ID);
        verify(model, times(0)).addAttribute(any(Owner.class));
    }
}
