package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import static org.mockito.Mockito.*;

public class PetController_initOwnerBinder_ae5e2b131f_Test {

    private PetController petController;
    private WebDataBinder dataBinder;

    @BeforeEach
    public void setup() {
        petController = new PetController();
        dataBinder = mock(WebDataBinder.class);
    }

    @Test
    public void testInitOwnerBinder_disallowedFieldSet() {
        petController.initOwnerBinder(dataBinder);
        verify(dataBinder, times(1)).setDisallowedFields("id");
    }

    @Test
    public void testInitOwnerBinder_noOtherDisallowedFieldsSet() {
        petController.initOwnerBinder(dataBinder);
        verify(dataBinder, never()).setDisallowedFields(anyString());
    }
}
