package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;

import static org.junit.jupiter.api.Assertions.*;

class PetController_initPetBinder_b0b1928cff_Test {

    @InjectMocks
    PetController petController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testInitPetBinder() {
        WebDataBinder dataBinder = new WebDataBinder(new Pet());
        petController.initPetBinder(dataBinder);

        assertTrue(dataBinder.getValidator() instanceof PetValidator);
    }

    @Test
    void testInitPetBinderWithInvalidPet() {
        WebDataBinder dataBinder = new WebDataBinder(null);
        petController.initPetBinder(dataBinder);

        assertTrue(dataBinder.getValidator() instanceof PetValidator);
        Pet pet = new Pet();
        pet.setName("Test");
        BindingResult result = new BeanPropertyBindingResult(pet, "pet");
        dataBinder.validate(pet, result);

        assertTrue(result.hasErrors());
    }
}
