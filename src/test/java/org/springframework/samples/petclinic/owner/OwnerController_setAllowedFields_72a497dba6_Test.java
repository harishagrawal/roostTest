package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

public class OwnerController_setAllowedFields_72a497dba6_Test {

    private WebDataBinder dataBinder;

    @BeforeEach
    public void setup() {
        dataBinder = Mockito.mock(WebDataBinder.class);
    }

    @Test
    public void testSetAllowedFields() {
        OwnerController controller = new OwnerController();
        controller.setAllowedFields(dataBinder);
        verify(dataBinder).setDisallowedFields("id");
    }

    @Test
    public void testSetAllowedFieldsWithDifferentField() {
        Mockito.doNothing().when(dataBinder).setDisallowedFields("name");
        OwnerController controller = new OwnerController();
        controller.setAllowedFields(dataBinder);
        verify(dataBinder).setDisallowedFields("id");
    }
}
