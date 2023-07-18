package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;

import static org.mockito.Mockito.*;

public class PetController_initPetBinder_b0b1928cff_Test {

    @Mock
    private WebDataBinder dataBinder;

    @InjectMocks
    private PetController petController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        petController = new PetController();
    }

    @Test
    public void testInitPetBinder() {
        petController.initPetBinder(dataBinder);
        verify(dataBinder).setValidator(any(PetValidator.class));
    }

    @Test
    public void testInitPetBinderWithNullDataBinder() {
        petController.initPetBinder(null);
        verify(dataBinder, times(0)).setValidator(any(PetValidator.class));
    }
}
