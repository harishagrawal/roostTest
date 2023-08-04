package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;

import static org.mockito.Mockito.*;

public class VisitController_setAllowedFields_72a497dba6_Test {

    private WebDataBinder dataBinder;

    @BeforeEach
    public void setup() {
        dataBinder = mock(WebDataBinder.class);
    }

    @Test
    public void testSetAllowedFieldsSuccess() {
        VisitController visitController = new VisitController();
        visitController.setAllowedFields(dataBinder);

        verify(dataBinder, times(1)).setDisallowedFields("id");
    }

    @Test
    public void testSetAllowedFieldsFailure() {
        VisitController visitController = new VisitController();
        visitController.setAllowedFields(dataBinder);

        verify(dataBinder, times(0)).setDisallowedFields("name");
    }
}
