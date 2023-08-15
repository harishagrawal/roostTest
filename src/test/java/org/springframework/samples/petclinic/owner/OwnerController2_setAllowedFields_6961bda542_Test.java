package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.web.bind.WebDataBinder;

import static org.junit.jupiter.api.Assertions.*;

class OwnerController2_setAllowedFields_6961bda542_Test {
  
    private WebDataBinder dataBinder;

    @BeforeEach
    void setUp() {
        dataBinder = new WebDataBinder(new Object());
    }

    @Test
    void testSetAllowedFields_IdDisallowed() {
        OwnerController2_setAllowedFields_6961bda542 ownerController = new OwnerController2_setAllowedFields_6961bda542();
        ownerController.setAllowedFields(dataBinder);

        assertTrue(dataBinder.isDisallowed("id"));
    }

    @Test
    void testSetAllowedFields_OtherFieldsAllowed() {
        OwnerController2_setAllowedFields_6961bda542 ownerController = new OwnerController2_setAllowedFields_6961bda542();
        ownerController.setAllowedFields(dataBinder);

        assertFalse(dataBinder.isDisallowed("name"));
        assertFalse(dataBinder.isDisallowed("age"));
        assertFalse(dataBinder.isDisallowed("address"));
    }
}
