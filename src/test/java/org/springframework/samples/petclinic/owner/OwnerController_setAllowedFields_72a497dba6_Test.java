package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.web.bind.WebDataBinder;

import static org.junit.jupiter.api.Assertions.*;

public class OwnerController_setAllowedFields_72a497dba6_Test {

    private WebDataBinder dataBinder;

    @BeforeEach
    public void setup() {
        dataBinder = new WebDataBinder(new Object());
    }

    @Test
    public void testSetAllowedFields_disallowsId() {
        setAllowedFields(dataBinder);
        assertTrue(dataBinder.getDisallowedFields().contains("id"));
    }

    @Test
    public void testSetAllowedFields_allowsOtherFields() {
        setAllowedFields(dataBinder);
        BeanPropertyBindingResult result = new BeanPropertyBindingResult(new Object(), "name");
        dataBinder.validate(result);
        assertFalse(result.hasErrors());
    }

    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }
}
