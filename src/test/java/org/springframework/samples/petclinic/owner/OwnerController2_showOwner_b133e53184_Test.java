package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.servlet.ModelAndView;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class OwnerController2_showOwner_b133e53184_Test {

    @Mock
    private OwnerRepository owners;

    @InjectMocks
    private OwnerController ownerController;

    @Test
    public void testShowOwner_success() {
        Owner mockOwner = new Owner();
        mockOwner.setId(1);
        mockOwner.setFirstName("John");
        mockOwner.setLastName("Doe");

        when(owners.findById(1)).thenReturn(mockOwner);

        ModelAndView mav = ownerController.showOwner(1);

        assertEquals("owners/ownerDetails", mav.getViewName());
        assertSame(mockOwner, mav.getModel().get("owner"));
    }

    @Test
    public void testShowOwner_ownerNotFound() {
        when(owners.findById(1)).thenReturn(null);

        ModelAndView mav = ownerController.showOwner(1);

        assertEquals("owners/ownerDetails", mav.getViewName());
        assertNull(mav.getModel().get("owner"));
    }
}
