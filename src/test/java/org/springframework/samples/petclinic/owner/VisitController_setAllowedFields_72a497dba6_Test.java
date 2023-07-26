package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import static org.mockito.Mockito.*;

class VisitController_setAllowedFields_72a497dba6_Test {

    private WebDataBinder dataBinder;

    @BeforeEach
    void setUp() {
        this.dataBinder = mock(WebDataBinder.class);
    }

    @Test
    void testSetAllowedFields_DisallowedId() {
        VisitController visitController = new VisitController();
        visitController.setAllowedFields(this.dataBinder);
        verify(this.dataBinder).setDisallowedFields("id");
    }

    @Test
    void testSetAllowedFields_AllowedOtherFields() {
        VisitController visitController = new VisitController();
        visitController.setAllowedFields(this.dataBinder);
        verify(this.dataBinder, never()).setDisallowedFields(anyString());
    }
}
