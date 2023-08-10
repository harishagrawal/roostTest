package org.springframework.samples.petclinic.owner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.validation.DataBinder;

public class PetController_initPetBinder_b0b1928cff_Test {

    private PetController petController;
    private DataBinder dataBinder;
    private PetValidator petValidator;

    @BeforeEach
    public void setup() {
        petController = new PetController();
        dataBinder = mock(DataBinder.class);
        petValidator = new PetValidator();
    }

    @Test
    public void testInitPetBinder() {
        petController.initPetBinder(dataBinder);
        verify(dataBinder).setValidator(petValidator);
    }

    @Test
    public void testInitPetBinder_NullDataBinder() {
        Exception exception = null;
        try {
            petController.initPetBinder(null);
        } catch (NullPointerException ex) {
            exception = ex;
        }
        assertEquals(NullPointerException.class, exception.getClass());
        assertEquals("DataBinder cannot be null", exception.getMessage());
    }
}
