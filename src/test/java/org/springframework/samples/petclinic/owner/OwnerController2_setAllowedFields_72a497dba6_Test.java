package org.springframework.samples.petclinic.owner;

import static org.mockito.Mockito.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;

public class OwnerController2_setAllowedFields_72a497dba6_Test {

    private WebDataBinder dataBinder;
    private OwnerController ownerController;

    @BeforeEach
    public void setup() {
        dataBinder = mock(WebDataBinder.class);
        ownerController = new OwnerController();
    }

    @Test
    public void testSetAllowedFields() {
        ownerController.setAllowedFields(dataBinder);
        verify(dataBinder, times(1)).setDisallowedFields("id");
    }

    @Test
    public void testSetAllowedFieldsWithDifferentField() {
        ownerController.setAllowedFields(dataBinder);
        verify(dataBinder, times(0)).setDisallowedFields("name");
    }
}
