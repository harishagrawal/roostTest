package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
public class OwnerController_initFindForm_4da4a6fd02_Test {

    @InjectMocks
    OwnerController ownerController = new OwnerController();

    @Test
    public void testInitFindForm_Success() {
        Model model = mock(Model.class);
        String view = ownerController.initFindForm(model);
        assertEquals("owners/findOwners", view);
    }

    @Test
    public void testInitFindForm_Failure() {
        Model model = mock(Model.class);
        String view = ownerController.initFindForm(model);
        assertEquals("owners/findOwners", view);
    }
}
