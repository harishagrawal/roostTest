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

    @InjectMocks
    PetController petController;

    @Mock
    WebDataBinder dataBinder;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
        petController = new PetController();
        dataBinder = mock(WebDataBinder.class);
    }

    @Test
    public void testInitPetBinder() {
        petController.initPetBinder(dataBinder);
        verify(dataBinder, times(1)).setValidator(any(PetValidator.class));
    }

    @Test
    public void testInitPetBinder_ValidatorNotSet() {
        doThrow(new RuntimeException()).when(dataBinder).setValidator(any(PetValidator.class));
        try {
            petController.initPetBinder(dataBinder);
        } catch (RuntimeException re) {
            verify(dataBinder, times(1)).setValidator(any(PetValidator.class));
        }
    }
}
