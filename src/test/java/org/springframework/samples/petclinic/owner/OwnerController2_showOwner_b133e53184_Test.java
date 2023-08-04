package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.servlet.ModelAndView;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class OwnerController2_showOwner_b133e53184_Test {

    @InjectMocks
    OwnerController ownerController;

    @Mock
    OwnerRepository owners;

    @Mock
    Owner owner;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        ownerController = new OwnerController();
        owners = new OwnerRepository();
        owner = new Owner();
    }

    @Test
    public void testShowOwner_ValidId() {
        when(owners.findById(1)).thenReturn(owner);

        ModelAndView mav = ownerController.showOwner(1);

        assertEquals("owners/ownerDetails", mav.getViewName());
        assertEquals(owner, mav.getModel().get("owner"));
    }

    @Test
    public void testShowOwner_InvalidId() {
        when(owners.findById(-1)).thenReturn(null);

        ModelAndView mav = ownerController.showOwner(-1);

        assertEquals("owners/ownerDetails", mav.getViewName());
        assertEquals(null, mav.getModel().get("owner"));
    }
}
