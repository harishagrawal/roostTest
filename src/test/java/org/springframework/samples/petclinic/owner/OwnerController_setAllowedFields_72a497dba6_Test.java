package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;

import static org.mockito.Mockito.*;

public class OwnerController_setAllowedFields_72a497dba6_Test {

    private WebDataBinder dataBinder;

    @BeforeEach
    public void setUp() {
        dataBinder = mock(WebDataBinder.class);
    }

    @Test
    public void testSetAllowedFields() {
        OwnerController ownerController = new OwnerController();
        ownerController.setAllowedFields(dataBinder);
        verify(dataBinder, times(1)).setDisallowedFields("id");
    }

    @Test
    public void testSetAllowedFieldsWithNullBinder() {
        OwnerController ownerController = new OwnerController();
        try {
            ownerController.setAllowedFields(null);
        } catch (NullPointerException e) {
            assert(e.getMessage().contains("WebDataBinder cannot be null"));
        }
    }
}
