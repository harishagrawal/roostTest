package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class OwnerController_showOwner_b133e53184_Test {

    private OwnerController ownerController;
    private OwnerRepository owners;
    private Owner owner;

    @BeforeEach
    public void setup() {
        owners = Mockito.mock(OwnerRepository.class);
        ownerController = new OwnerController(owners);
        owner = new Owner();
        owner.setId(1);
        owner.setFirstName("John");
        owner.setLastName("Doe");
    }

    @Test
    public void testShowOwner() {
        when(owners.findById(1)).thenReturn(owner);
        ModelAndView mav = ownerController.showOwner(1);
        ModelMap modelMap = mav.getModelMap();

        assertEquals("owners/ownerDetails", mav.getViewName());
        assertEquals(owner, modelMap.get("owner"));
    }

    @Test
    public void testShowOwnerNotFound() {
        when(owners.findById(1)).thenReturn(null);
        ModelAndView mav = ownerController.showOwner(1);
        ModelMap modelMap = mav.getModelMap();

        assertEquals("owners/ownerDetails", mav.getViewName());
        assertEquals(null, modelMap.get("owner"));
    }
}
