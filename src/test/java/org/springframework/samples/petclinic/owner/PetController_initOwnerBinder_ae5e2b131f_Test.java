package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.bind.WebDataBinder;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.never;

public class PetController_initOwnerBinder_ae5e2b131f_Test {

    @InjectMocks
    private PetController petController;

    @Mock
    private WebDataBinder dataBinder;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
        petController = new PetController();
        dataBinder = new WebDataBinder(new Object());
    }

    @Test
    public void testInitOwnerBinder() {
        petController.initOwnerBinder(dataBinder);
        verify(dataBinder).setDisallowedFields("id");
    }

    @Test
    public void testInitOwnerBinderWithNullDataBinder() {
        petController.initOwnerBinder(null);
        verify(dataBinder, never()).setDisallowedFields("id");
    }
}
