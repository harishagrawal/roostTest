package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.web.bind.WebDataBinder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

public class PetController_initPetBinder_b0b1928cff_Test {

    @Mock
    private WebDataBinder dataBinder;

    private PetController petController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        petController = new PetController();
    }

    @Test
    public void testInitPetBinder() {
        PetValidator petValidator = new PetValidator();
        petController.initPetBinder(dataBinder);
        verify(dataBinder).setValidator(petValidator);
    }

    @Test
    public void testInitPetBinderWithInvalidData() {
        Pet pet = new Pet();
        pet.setName("Max");
        pet.setBirthDate(null); 
        BeanPropertyBindingResult errors = new BeanPropertyBindingResult(pet, "pet");

        petController.initPetBinder(dataBinder);
        dataBinder.validate(pet, errors);

        assertEquals(1, errors.getErrorCount());
        assertEquals("Birth date is required", errors.getFieldError("birthDate").getDefaultMessage());
    }
}
