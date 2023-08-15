package org.springframework.samples.petclinic.owner;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.never;

import org.springframework.web.bind.WebDataBinder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class VisitController_setAllowedFields_6961bda542_Test {

    private VisitController visitController;
    private WebDataBinder dataBinder;

    @BeforeEach
    public void setup() {
        visitController = new VisitController();
        dataBinder = mock(WebDataBinder.class);
    }

    @Test
    public void testSetAllowedFields_DisallowsIdField() {
        visitController.setAllowedFields(dataBinder);
        verify(dataBinder).setDisallowedFields("id");
    }

    @Test
    public void testSetAllowedFields_DoesNotDisallowOtherFields() {
        visitController.setAllowedFields(dataBinder);
        verify(dataBinder, never()).setDisallowedFields("otherField");
    }
}
