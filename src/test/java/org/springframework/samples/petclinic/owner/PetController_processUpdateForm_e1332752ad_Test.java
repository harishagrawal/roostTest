package org.springframework.samples.petclinic.owner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;

@ExtendWith(MockitoExtension.class)
public class PetController_processUpdateForm_e1332752ad_Test {

    @Mock
    private Owner owner;

    @InjectMocks
    private PetController petController;

    private Pet pet;
    private BindingResult result;
    private ModelMap modelMap;

    @BeforeEach
    public void setup() {
        pet = new Pet();
        pet.setName("Tommy");
        pet.setId(1);
        pet.setBirthDate(LocalDate.of(2020, 1, 1));

        when(owner.getPet("tommy", false)).thenReturn(null);

        result = new BeanPropertyBindingResult(pet, "pet");
        modelMap = new ModelMap();
    }

    @Test
    public void testProcessUpdateForm_success() {
        String view = petController.processUpdateForm(pet, result, owner, modelMap);

        assertEquals("redirect:/owners/{ownerId}", view);
    }

    @Test
    public void testProcessUpdateForm_duplicatePetName() {
        when(owner.getPet("tommy", false)).thenReturn(new Pet());

        String view = petController.processUpdateForm(pet, result, owner, modelMap);

        assertEquals("pets/createOrUpdatePetForm", view);
        assertEquals("already exists", result.getFieldError("name").getDefaultMessage());
    }

    @Test
    public void testProcessUpdateForm_futureBirthDate() {
        pet.setBirthDate(LocalDate.now().plusDays(1));

        String view = petController.processUpdateForm(pet, result, owner, modelMap);

        assertEquals("pets/createOrUpdatePetForm", view);
        assertEquals("typeMismatch.birthDate", result.getFieldError("birthDate").getCode());
    }
}
