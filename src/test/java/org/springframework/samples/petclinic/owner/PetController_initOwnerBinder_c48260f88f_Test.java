package org.springframework.samples.petclinic.owner;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.junit.Test;
import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.verify;

public class PetController_initOwnerBinder_c48260f88f_Test {

    @Mock
    private WebDataBinder dataBinder;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testInitOwnerBinder_disallowId() {
        PetController petController = new PetController();
        petController.initOwnerBinder(dataBinder);
        verify(dataBinder).setDisallowedFields("id");
    }

    @Test
    public void testInitOwnerBinder_disallowOtherFields() {
        PetController petController = new PetController();
        petController.initOwnerBinder(dataBinder);
        verify(dataBinder).setDisallowedFields("otherField");
    }
}
