package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.Test;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.web.bind.WebDataBinder;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OwnerController_setAllowedFields_72a497dba6_Test {

    @Test
    public void testSetAllowedFields() {
        OwnerController controller = new OwnerController();
        WebDataBinder dataBinder = new WebDataBinder(new Object(), "target");
        controller.setAllowedFields(dataBinder);
        BeanPropertyBindingResult result = (BeanPropertyBindingResult) dataBinder.getBindingResult();
        assertEquals(1, result.getSuppressedFields().length);
        assertEquals("id", result.getSuppressedFields()[0]);
    }

    @Test
    public void testSetAllowedFieldsWithOtherDisallowedField() {
        OwnerController controller = new OwnerController();
        WebDataBinder dataBinder = new WebDataBinder(new Object(), "target");
        dataBinder.setDisallowedFields("otherField");
        controller.setAllowedFields(dataBinder);
        BeanPropertyBindingResult result = (BeanPropertyBindingResult) dataBinder.getBindingResult();
        assertEquals(2, result.getSuppressedFields().length);
        // TODO: The order of disallowed fields might vary, adjust the index accordingly
        assertEquals("id", result.getSuppressedFields()[0]);
        assertEquals("otherField", result.getSuppressedFields()[1]);
    }
}
