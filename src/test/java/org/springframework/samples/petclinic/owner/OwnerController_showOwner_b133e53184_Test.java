package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.servlet.ModelAndView;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@SpringBootTest
public class OwnerController_showOwner_b133e53184_Test {

    @MockBean
    private OwnerRepository owners;

    private OwnerController ownerController;

    @BeforeEach
    void setup() {
        ownerController = new OwnerController(owners);
    }

    @Test
    public void testShowOwner_ValidId() {
        Owner testOwner = new Owner();
        testOwner.setId(1);
        testOwner.setFirstName("John");
        testOwner.setLastName("Doe");

        when(owners.findById(anyInt())).thenReturn(java.util.Optional.of(testOwner));

        ModelAndView mav = ownerController.showOwner(1);

        assertEquals("owners/ownerDetails", mav.getViewName());
        assertEquals(testOwner, mav.getModel().get("owner"));
    }

    @Test
    public void testShowOwner_InvalidId() {
        when(owners.findById(anyInt())).thenReturn(java.util.Optional.empty());

        ModelAndView mav = ownerController.showOwner(999);

        assertEquals("owners/ownerDetails", mav.getViewName());
        assertEquals(null, mav.getModel().get("owner"));
    }
}
