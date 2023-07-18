package org.springframework.samples.petclinic.owner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

public class PetController_processCreationForm_c3fe45c8ee_Test {

    @Mock
    private OwnerRepository owners;

    @Mock
    private Pet pet;

    @Mock
    private Owner owner;

    @Mock
    private BindingResult result;

    @Mock
    private ModelMap model;

    @InjectMocks
    private PetController petController;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testProcessCreationForm_duplicatePetName() {
        when(pet.getName()).thenReturn("Rex");
        when(pet.isNew()).thenReturn(true);
        when(owner.getPet("Rex", true)).thenReturn(new Pet());

        String view = petController.processCreationForm(owner, pet, result, model);

        verify(result).rejectValue("name", "duplicate", "already exists");
        assertEquals("pets/createOrUpdatePetForm", view);
    }

    @Test
    public void testProcessCreationForm_futureBirthDate() {
        when(pet.getBirthDate()).thenReturn(LocalDate.now().plusDays(1));

        String view = petController.processCreationForm(owner, pet, result, model);

        verify(result).rejectValue("birthDate", "typeMismatch.birthDate");
        assertEquals("pets/createOrUpdatePetForm", view);
    }

    @Test
    public void testProcessCreationForm_success() {
        when(pet.getName()).thenReturn("Rex");
        when(pet.isNew()).thenReturn(true);
        when(owner.getPet("Rex", true)).thenReturn(null);
        when(pet.getBirthDate()).thenReturn(LocalDate.now().minusDays(1));
        when(result.hasErrors()).thenReturn(false);

        String view = petController.processCreationForm(owner, pet, result, model);

        verify(owners).save(any(Owner.class));
        assertEquals("redirect:/owners/{ownerId}", view);
    }
}
