package org.springframework.samples.petclinic.owner;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.servlet.ModelAndView;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class OwnerController_showOwner_b133e53184_Test {

    @InjectMocks
    private OwnerController ownerController;

    @Mock
    private OwnerRepository owners;

    @Mock
    private Owner owner;

    @Before
    public void setup() {
        when(owners.findById(anyInt())).thenReturn(java.util.Optional.ofNullable(owner));
    }

    @Test
    public void testShowOwner_ValidId() {
        int ownerId = 1;
        ModelAndView mav = ownerController.showOwner(ownerId);
        assertEquals("owners/ownerDetails", mav.getViewName());
        assertEquals(owner, mav.getModel().get("owner"));
    }

    @Test
    public void testShowOwner_InvalidId() {
        int ownerId = -1;
        when(owners.findById(anyInt())).thenReturn(java.util.Optional.empty());
        ModelAndView mav = ownerController.showOwner(ownerId);
        assertEquals("exception", mav.getViewName());
        assertEquals(null, mav.getModel().get("owner"));
    }

}
