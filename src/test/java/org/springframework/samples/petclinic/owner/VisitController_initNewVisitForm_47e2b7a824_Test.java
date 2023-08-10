package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class VisitController_initNewVisitForm_47e2b7a824_Test {

    private VisitController visitController;

    @BeforeEach
    void setup() {
        visitController = new VisitController();
    }

    @Test
    void testInitNewVisitForm() {
        String view = visitController.initNewVisitForm();
        assertEquals("pets/createOrUpdateVisitForm", view);
    }

    @Test
    void testInitNewVisitFormWithDifferentReturn() {
        String view = visitController.initNewVisitForm();
        assertNotEquals("pets/someOtherForm", view);
    }
}
