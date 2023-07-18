package org.springframework.samples.petclinic.owner;

import org.springframework.web.bind.WebDataBinder;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OwnerController_setAllowedFields_72a497dba6_Test {

    @Test
    public void testSetAllowedFields() {
        WebDataBinder dataBinder = new WebDataBinder(new Object());
        OwnerController ownerController = new OwnerController();
        ownerController.setAllowedFields(dataBinder);
        assertTrue(dataBinder.isDisallowed("id"));
    }

    @Test
    public void testSetAllowedFieldsWithInvalidField() {
        WebDataBinder dataBinder = new WebDataBinder(new Object());
        OwnerController ownerController = new OwnerController();
        ownerController.setAllowedFields(dataBinder);
        assertFalse(dataBinder.isDisallowed("name"));
    }
}
