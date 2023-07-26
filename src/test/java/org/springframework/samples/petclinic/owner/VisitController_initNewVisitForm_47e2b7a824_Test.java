package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VisitController_initNewVisitForm_47e2b7a824_Test {

    @InjectMocks
    private VisitController visitController;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
        visitController = new VisitController();
    }

    @Test
    public void testInitNewVisitForm() {
        String viewName = visitController.initNewVisitForm();
        assertEquals("pets/createOrUpdateVisitForm", viewName);
    }

    @Test
    public void testInitNewVisitFormFail() {
        String viewName = visitController.initNewVisitForm();
        assertEquals("pets/wrongForm", viewName);
    }
}
