package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.bind.WebDataBinder;

import static org.mockito.Mockito.verify;

public class VisitController_setAllowedFields_72a497dba6_Test {

    @Mock
    private WebDataBinder dataBinder;

    @InjectMocks
    private VisitController visitController;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
        visitController = new VisitController();
    }

    @Test
    public void testSetAllowedFields() {
        visitController.setAllowedFields(dataBinder);
        verify(dataBinder).setDisallowedFields("id");
    }

    @Test
    public void testSetAllowedFieldsWithDifferentField() {
        visitController.setAllowedFields(dataBinder);
        verify(dataBinder).setDisallowedFields("otherField");
    }
}
