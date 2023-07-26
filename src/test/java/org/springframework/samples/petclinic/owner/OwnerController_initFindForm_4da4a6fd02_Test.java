package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class OwnerController_initFindForm_4da4a6fd02_Test {

    @Autowired
    private OwnerController ownerController;

    @MockBean
    private Model model;

    @Test
    public void testInitFindForm_Success() {
        String viewName = ownerController.initFindForm(new Model());
        assertEquals("owners/findOwners", viewName, "Expected view name to be 'owners/findOwners'");
    }

    @Test
    public void testInitFindForm_Failure() {
        when(model.addAttribute("owner", "John")).thenReturn(new Model());
        String viewName = ownerController.initFindForm(new Model());
        assertEquals(null, viewName, "Expected null as view name");
    }
}
