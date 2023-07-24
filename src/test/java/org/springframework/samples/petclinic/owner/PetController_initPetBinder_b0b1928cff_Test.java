package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
public class PetController_initPetBinder_b0b1928cff_Test {

    @Mock
    private PetValidator petValidator;

    @InjectMocks
    private PetController petController;

    @Test
    public void testInitPetBinder() {
        Pet pet = new Pet();
        WebDataBinder dataBinder = new WebDataBinder(pet, "pet");
        petController.initPetBinder(dataBinder);
        Validator validator = dataBinder.getValidator();

        assertNotNull(validator, "Validator should not be null");
        assertEquals(PetValidator.class, validator.getClass(), "Validator class should be PetValidator");
    }

    @Test
    public void testInitPetBinderWithNull() {
        WebDataBinder dataBinder = null;

        try {
            petController.initPetBinder(dataBinder);
        } catch (NullPointerException e) {
            assertEquals("dataBinder cannot be null", e.getMessage());
        }
    }
}
