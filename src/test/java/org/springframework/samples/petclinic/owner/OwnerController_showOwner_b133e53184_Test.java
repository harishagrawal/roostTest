package org.springframework.samples.petclinic.owner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.servlet.ModelAndView;

public class OwnerController_showOwner_b133e53184_Test {

    @Mock
    private OwnerRepository owners;

    private OwnerController ownerController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        ownerController = new OwnerController();
        ownerController.setOwnerRepository(owners);
    }

    @Test
    public void testShowOwner_ExistingOwner() {
        int ownerId = 1;
        Owner owner = new Owner();
        owner.setId(ownerId);
        when(owners.findById(ownerId)).thenReturn(owner);

        ModelAndView mav = ownerController.showOwner(ownerId);

        assertEquals("owners/ownerDetails", mav.getViewName());
        assertEquals(owner, mav.getModel().get("owner"));
    }

    @Test
    public void testShowOwner_NonExistingOwner() {
        int ownerId = 2;
        when(owners.findById(ownerId)).thenReturn(null);

        ModelAndView mav = ownerController.showOwner(ownerId);

        assertEquals("owners/ownerDetails", mav.getViewName());
        assertEquals(null, mav.getModel().get("owner"));
    }
}
