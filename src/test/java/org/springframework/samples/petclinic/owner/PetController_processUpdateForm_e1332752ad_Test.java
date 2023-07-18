package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class PetController_processUpdateForm_e1332752ad_Test {

    @Mock
    private BindingResult result;

    @Mock
    private ModelMap model;

    private Pet pet;
    private Owner owner;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        pet = new Pet();
        owner = new Owner();
    }

    @Test
    public void testProcessUpdateForm_duplicateName() {
        pet.setName("Rex");
        pet.setId(1);
        owner.addPet(pet);

        Pet newPet = new Pet();
        newPet.setName("Rex");
        newPet.setId(2);

        when(result.hasErrors()).thenReturn(true);

        String view = new PetController().processUpdateForm(newPet, result, owner, model);

        verify(result).rejectValue("name", "duplicate", "already exists");
        assertEquals("pets/createOrUpdateForm", view);
    }

    @Test
    public void testProcessUpdateForm_futureBirthDate() {
        pet.setBirthDate(LocalDate.now().plusDays(1));

        when(result.hasErrors()).thenReturn(true);

        String view = new PetController().processUpdateForm(pet, result, owner, model);

        verify(result).rejectValue("birthDate", "typeMismatch.birthDate");
        assertEquals("pets/createOrUpdateForm", view);
    }

    @Test
    public void testProcessUpdateForm_success() {
        pet.setName("Rex");
        pet.setId(1);
        pet.setBirthDate(LocalDate.now().minusYears(1));

        when(result.hasErrors()).thenReturn(false);

        String view = new PetController().processUpdateForm(pet, result, owner, model);

        assertEquals("redirect:/owners/{ownerId}", view);
    }
}
