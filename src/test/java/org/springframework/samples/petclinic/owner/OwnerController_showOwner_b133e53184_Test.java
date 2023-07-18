package org.springframework.samples.petclinic.owner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.servlet.ModelAndView;

public class OwnerController_showOwner_b133e53184_Test {

    @InjectMocks
    OwnerController ownerController = new OwnerController();

    @Mock
    OwnerRepository owners = new OwnerRepository();

    @Mock
    Owner owner = new Owner();

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testShowOwner_success() {
        int ownerId = 1; 
        when(owners.findById(ownerId)).thenReturn(owner);
        ModelAndView mav = ownerController.showOwner(ownerId);
        assertEquals("owners/ownerDetails", mav.getViewName());
        assertEquals(owner, mav.getModel().get("owner"));
    }

    @Test
    public void testShowOwner_ownerNotFound() {
        int ownerId = 1;
        when(owners.findById(ownerId)).thenReturn(null);
        ModelAndView mav = ownerController.showOwner(ownerId);
        assertEquals("owners/ownerDetails", mav.getViewName());
        assertEquals(null, mav.getModel().get("owner"));
    }
}
