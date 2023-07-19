package org.springframework.samples.petclinic.owner;

import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.web.bind.WebDataBinder;

public class VisitController_setAllowedFields_72a497dba6_Test {

    private VisitController visitController;
    private WebDataBinder dataBinder;

    @BeforeEach
    public void setup() {
        visitController = new VisitController();
        dataBinder = mock(WebDataBinder.class);
    }

    @Test
    public void testSetAllowedFields() {
        visitController.setAllowedFields(dataBinder);
        verify(dataBinder, times(1)).setDisallowedFields("id");
    }

    @Test
    public void testSetAllowedFieldsWithNull() {
        visitController.setAllowedFields(null);
        verify(dataBinder, never()).setDisallowedFields(anyString());
    }
}
