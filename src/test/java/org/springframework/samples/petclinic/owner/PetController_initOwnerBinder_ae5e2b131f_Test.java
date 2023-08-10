package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.web.bind.WebDataBinder;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PetController_initOwnerBinder_ae5e2b131f_Test {

    private WebDataBinder dataBinder;

    @BeforeEach
    public void setUp() {
        this.dataBinder = new WebDataBinder(new Object());
    }

    @Test
    public void testInitOwnerBinder_disallowsIdField() {
        PetController controller = new PetController();
        controller.initOwnerBinder(dataBinder);

        assertTrue(dataBinder.getDisallowedFields().contains("id"));
    }

    @Test
    public void testInitOwnerBinder_allowsOtherFields() {
        PetController controller = new PetController();
        controller.initOwnerBinder(dataBinder);

        dataBinder.bind(new BeanPropertyBindingResult(new Object(), "name"));

        assertTrue(!dataBinder.getBindingResult().hasErrors());
    }
}
