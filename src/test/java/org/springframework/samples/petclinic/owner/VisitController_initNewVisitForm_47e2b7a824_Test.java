package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
public class VisitController_initNewVisitForm_47e2b7a824_Test {

    @InjectMocks
    private VisitController visitController = new VisitController();

    private Model model;
    private BindingResult result;

    @BeforeEach
    public void setup() {
        model = mock(Model.class);
        result = mock(BindingResult.class);
    }

    @Test
    public void testInitNewVisitForm_success() {
        String view = visitController.initNewVisitForm();
        assertEquals("pets/createOrUpdateVisitForm", view);
    }

    @Test
    public void testInitNewVisitForm_failure() {
        String view = visitController.initNewVisitForm();
        assertEquals("pets/createOrUpdateVisitForm", view);
    }
}
