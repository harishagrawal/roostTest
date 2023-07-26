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
import org.springframework.validation.BindingResult;

public class PetController_processUpdateForm_e1332752ad_Test {

    @InjectMocks
    private PetController petController;

    @Mock
    private BindingResult result;

    @Mock
    private Owner owner;

    @Mock
    private Pet pet;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testProcessUpdateForm_withDuplicatePetName() {
        when(pet.getName()).thenReturn("Rex");
        Pet newPet = new Pet();
        newPet.setId(2);
        when(owner.getPet("Rex", false)).thenReturn(newPet);
        when(pet.getId()).thenReturn(1);

        String view = petController.processUpdateForm(pet, result, owner, new ModelMap());

        assertEquals("pets/createOrUpdatePetForm", view);
    }

    @Test
    public void testProcessUpdateForm_withFutureBirthDate() {
        when(pet.getName()).thenReturn("Rex");
        when(owner.getPet("Rex", false)).thenReturn(null);
        when(pet.getBirthDate()).thenReturn(LocalDate.now().plusDays(1));

        String view = petController.processUpdateForm(pet, result, owner, new ModelMap());

        assertEquals("pets/createOrUpdatePetForm", view);
    }

    @Test
    public void testProcessUpdateForm_withValidPet() {
        when(pet.getName()).thenReturn("Rex");
        when(owner.getPet("Rex", false)).thenReturn(null);
        when(pet.getBirthDate()).thenReturn(LocalDate.now().minusYears(1));

        String view = petController.processUpdateForm(pet, result, owner, new ModelMap());

        assertEquals("redirect:/owners/{ownerId}", view);
    }
}
