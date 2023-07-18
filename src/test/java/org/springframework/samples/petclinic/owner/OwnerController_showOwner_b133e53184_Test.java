package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.servlet.ModelAndView;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class OwnerController_showOwner_b133e53184_Test {

    @InjectMocks
    OwnerController ownerController;

    @Mock
    OwnerRepository owners;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
        ownerController = new OwnerController();
    }

    @Test
    public void testShowOwner_success() {
        Owner testOwner = new Owner();
        testOwner.setId(1);
        testOwner.setFirstName("John");
        testOwner.setLastName("Doe");

        when(owners.findById(1)).thenReturn(testOwner);

        ModelAndView mav = ownerController.showOwner(1);

        assertEquals("owners/ownerDetails", mav.getViewName());
        assertEquals(testOwner, mav.getModel().get("owner"));
    }

    @Test
    public void testShowOwner_ownerNotFound() {
        when(owners.findById(1)).thenReturn(null);

        ModelAndView mav = ownerController.showOwner(1);

        assertEquals("owners/ownerDetails", mav.getViewName());
        assertEquals(null, mav.getModel().get("owner"));
    }
}
