package org.springframework.samples.petclinic.owner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class OwnerController_initFindForm_4da4a6fd02_Test {

    @Autowired
    private OwnerController ownerController;

    @MockBean
    private OwnerRepository owners;

    @BeforeEach
    void setup() {
        // ownerController = new OwnerController();
    }

    @Test
    public void testInitFindForm_Success() {
        String viewName = ownerController.initFindForm();
        assertEquals("owners/findOwners", viewName);
    }

    @Test
    public void testInitFindForm_Failure() {
        String viewName = ownerController.initFindForm();
        assertEquals("owners/notFindOwners", viewName);
    }
}
