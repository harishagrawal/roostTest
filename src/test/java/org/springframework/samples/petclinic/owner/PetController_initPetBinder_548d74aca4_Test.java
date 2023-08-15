package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class PetController_initPetBinder_548d74aca4_Test {

    @Mock
    private WebDataBinder dataBinder;

    @Mock
    private PetValidator petValidator;

    @InjectMocks
    private PetController petController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testInitPetBinder() {
        when(dataBinder.getValidator()).thenReturn(petValidator);
        petController.initPetBinder(dataBinder);
        verify(dataBinder).setValidator(petValidator);
    }

    @Test
    public void testInitPetBinder_NullValidator() {
        when(dataBinder.getValidator()).thenReturn(null);
        petController.initPetBinder(dataBinder);
        verify(dataBinder).setValidator(new PetValidator());
    }
}
