package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;

import static org.mockito.Mockito.*;

public class OwnerController2_setAllowedFields_72a497dba6_Test {

    private WebDataBinder dataBinder;

    @BeforeEach
    public void setup() {
        dataBinder = mock(WebDataBinder.class);
    }

    @Test
    public void testSetAllowedFields() {
        OwnerController ownerController = new OwnerController();
        ownerController.setAllowedFields(dataBinder);
        verify(dataBinder).setDisallowedFields("id");
    }

    @Test
    public void testSetAllowedFields_WhenDataBinderIsNull() {
        OwnerController ownerController = new OwnerController();
        try {
            ownerController.setAllowedFields(null);
        } catch (IllegalArgumentException e) {
            assertEquals("DataBinder must not be null", e.getMessage());
        }
    }
}
