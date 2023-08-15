package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.servlet.ModelAndView;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class OwnerController2_showOwner_db2a323b89_Test {

    @InjectMocks
    private OwnerController ownerController;

    @Mock
    private OwnerRepository owners;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testShowOwner() {
        Owner owner = new Owner();
        owner.setId(1);
        when(owners.findById(1)).thenReturn(owner);

        ModelAndView mav = ownerController.showOwner(1);

        assertEquals("owners/ownerDetails", mav.getViewName());
        assertEquals(owner, mav.getModel().get("owner"));
    }

    @Test
    public void testShowOwnerNotFound() {
        when(owners.findById(1)).thenReturn(null);

        ModelAndView mav = ownerController.showOwner(1);

        assertEquals("owners/ownerDetails", mav.getViewName());
        assertEquals(null, mav.getModel().get("owner"));
    }
}
