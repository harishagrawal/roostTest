package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class OwnerController_setAllowedFields_72a497dba6_Test {

    private WebDataBinder dataBinder;

    @BeforeEach
    public void setup() {
        dataBinder = mock(WebDataBinder.class);
    }

    @Test
    public void testSetAllowedFields_disallowsId() {
        OwnerController controller = new OwnerController();
        controller.setAllowedFields(dataBinder);
        verify(dataBinder).setDisallowedFields("id");
    }

    @Test
    public void testSetAllowedFields_allowsOtherFields() {
        OwnerController controller = new OwnerController();
        controller.setAllowedFields(dataBinder);
        verify(dataBinder, never()).setDisallowedFields("name");
        verify(dataBinder, never()).setDisallowedFields("address");
    }
}
