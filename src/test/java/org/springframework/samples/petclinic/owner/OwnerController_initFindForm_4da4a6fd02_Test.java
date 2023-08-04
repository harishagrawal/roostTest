package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class OwnerController_initFindForm_4da4a6fd02_Test {

    @InjectMocks
    private OwnerController ownerController;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testInitFindForm() {
        String expectedView = "owners/findOwners";
        String actualView = ownerController.initFindForm();
        assertEquals(expectedView, actualView, "Expected view did not match actual view");
    }

    @Test
    public void testInitFindFormWithDifferentView() {
        String expectedView = "owners/differentView";
        String actualView = ownerController.initFindForm();
        assertNotEquals(expectedView, actualView, "Expected view should not match actual view");
    }
}
