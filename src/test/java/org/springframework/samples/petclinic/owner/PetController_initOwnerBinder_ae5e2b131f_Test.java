package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PetController_initOwnerBinder_ae5e2b131f_Test {

    private PetController petController;
    private WebDataBinder dataBinder;

    @BeforeEach
    void setUp() {
        petController = new PetController();
        dataBinder = mock(WebDataBinder.class);
    }

    @Test
    void testInitOwnerBinder_disallowedField() {
        petController.initOwnerBinder(dataBinder);
        verify(dataBinder).setDisallowedFields("id");
    }

    @Test
    void testInitOwnerBinder_noDisallowedField() {
        when(dataBinder.getDisallowedFields()).thenReturn(new String[]{});
        petController.initOwnerBinder(dataBinder);
        verify(dataBinder).setDisallowedFields("id");
    }
}
