package org.springframework.samples.petclinic.owner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;

public class PetController_processUpdateForm_e1332752ad_Test {

    @InjectMocks
    PetController petController = new PetController();

    @Mock
    Owner owner = new Owner();

    @Mock
    Pet pet = new Pet();

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testProcessUpdateForm_duplicatePetName() {
        BindingResult result = new BeanPropertyBindingResult(pet, "pet");
        ModelMap model = new ModelMap();

        when(pet.getName()).thenReturn("Max");
        when(owner.getPet("Max", false)).thenReturn(new Pet());

        String view = petController.processUpdateForm(pet, result, owner, model);
        assertEquals("pets/createOrUpdateForm", view);
        assertEquals("already exists", result.getFieldError("name").getDefaultMessage());
    }

    @Test
    public void testProcessUpdateForm_futureBirthDate() {
        BindingResult result = new BeanPropertyBindingResult(pet, "pet");
        ModelMap model = new ModelMap();

        when(pet.getBirthDate()).thenReturn(LocalDate.now().plusDays(1));

        String view = petController.processUpdateForm(pet, result, owner, model);
        assertEquals("pets/createOrUpdateForm", view);
        assertEquals("typeMismatch.birthDate", result.getFieldError("birthDate").getCode());
    }

    @Test
    public void testProcessUpdateForm_success() {
        BindingResult result = new BeanPropertyBindingResult(pet, "pet");
        ModelMap model = new ModelMap();

        when(pet.getName()).thenReturn("Max");
        when(owner.getPet("Max", false)).thenReturn(null);
        when(pet.getBirthDate()).thenReturn(LocalDate.now());

        String view = petController.processUpdateForm(pet, result, owner, model);
        assertEquals("redirect:/owners/{ownerId}", view);
    }
}
