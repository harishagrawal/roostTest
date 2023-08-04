package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class PetController_processUpdateForm_e1332752ad_Test {

    @InjectMocks
    PetController petController = new PetController();

    @Mock
    BindingResult result = mock(BindingResult.class);

    @Mock
    Owner owner = new Owner();

    @Mock
    ModelMap model = new ModelMap();

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testProcessUpdateForm_PetNameExists() {
        Pet pet = new Pet();
        pet.setName("Fluffy");
        pet.setId(1);

        when(owner.getPet("fluffy", false)).thenReturn(pet);
        when(result.hasErrors()).thenReturn(true);

        String view = petController.processUpdateForm(pet, result, owner, model);

        verify(result).rejectValue("name", "duplicate", "already exists");
        assertEquals("pets/createOrUpdatePetForm", view);
    }

    @Test
    public void testProcessUpdateForm_PetBirthDateInFuture() {
        Pet pet = new Pet();
        pet.setName("Fluffy");
        pet.setId(1);
        pet.setBirthDate(LocalDate.now().plusDays(1));

        when(owner.getPet("fluffy", false)).thenReturn(null);
        when(result.hasErrors()).thenReturn(true);

        String view = petController.processUpdateForm(pet, result, owner, model);

        verify(result).rejectValue("birthDate", "typeMismatch.birthDate");
        assertEquals("pets/createOrUpdatePetForm", view);
    }

    @Test
    public void testProcessUpdateForm_Success() {
        Pet pet = new Pet();
        pet.setName("Fluffy");
        pet.setId(1);
        pet.setBirthDate(LocalDate.now().minusYears(1));

        when(owner.getPet("fluffy", false)).thenReturn(null);
        when(result.hasErrors()).thenReturn(false);
        
        String view = petController.processUpdateForm(pet, result, owner, model);

        verify(owner).addPet(pet);
        assertEquals("redirect:/owners/{ownerId}", view);
    }
}
