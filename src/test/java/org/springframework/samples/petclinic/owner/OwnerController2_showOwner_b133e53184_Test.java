package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.servlet.ModelAndView;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class OwnerController2_showOwner_b133e53184_Test {

    @Mock
    private OwnerRepository owners;

    @InjectMocks
    private OwnerController ownerController;

    private Owner owner;

    @BeforeEach
    void setup() {
        owner = new Owner();
        owner.setId(1);
        owner.setFirstName("John");
        owner.setLastName("Doe");
    }

    @Test
    public void testShowOwner_Success() {
        when(owners.findById(1)).thenReturn(owner);

        ModelAndView mav = ownerController.showOwner(1);

        assertEquals("owners/ownerDetails", mav.getViewName());
        assertEquals(owner, mav.getModel().get("owner"));
    }

    @Test
    public void testShowOwner_Failure() {
        when(owners.findById(2)).thenReturn(null);

        ModelAndView mav = ownerController.showOwner(2);

        assertEquals("owners/ownerDetails", mav.getViewName());
        assertEquals(null, mav.getModel().get("owner"));
    }
}
