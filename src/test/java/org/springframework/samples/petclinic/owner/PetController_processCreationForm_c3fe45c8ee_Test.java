package org.springframework.samples.petclinic.owner;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

import java.time.LocalDate;

import org.junit.Test;
import org.junit.Before;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.MapBindingResult;
import org.springframework.validation.ObjectError;

public class PetController_processCreationForm_c3fe45c8ee_Test {

    private Owner owner;
    private Pet pet;
    private BindingResult result;
    private ModelMap model;
    private OwnerRepository owners;
    private PetController petController;

    @Before
    public void setup() {
        owner = mock(Owner.class);
        pet = mock(Pet.class);
        model = new ModelMap();
        result = new MapBindingResult(model, "pet");
        owners = mock(OwnerRepository.class);
        petController = new PetController(owners);
    }

    @Test
    public void testProcessCreationFormDuplicateName() {
        when(pet.getName()).thenReturn("Fido");
        when(pet.isNew()).thenReturn(true);
        when(owner.getPet("Fido", true)).thenReturn(new Pet());

        String view = petController.processCreationForm(owner, pet, result, model);

        assertEquals("pets/createOrUpdateForm", view);
        assertEquals(1, result.getErrorCount());
        assertEquals("name", ((ObjectError)result.getAllErrors().get(0)).getCodes()[0]);
    }

    @Test
    public void testProcessCreationFormFutureBirthDate() {
        when(pet.getBirthDate()).thenReturn(LocalDate.now().plusDays(1));

        String view = petController.processCreationForm(owner, pet, result, model);

        assertEquals("pets/createOrUpdateForm", view);
        assertEquals(1, result.getErrorCount());
        assertEquals("birthDate", ((ObjectError)result.getAllErrors().get(0)).getCodes()[0]);
    }

    @Test
    public void testProcessCreationFormSuccess() {
        when(pet.getName()).thenReturn("Fido");
        when(pet.isNew()).thenReturn(true);
        when(owner.getPet("Fido", true)).thenReturn(null);
        when(pet.getBirthDate()).thenReturn(LocalDate.now());

        String view = petController.processCreationForm(owner, pet, result, model);

        assertEquals("redirect:/owners/{ownerId}", view);
        assertEquals(0, result.getErrorCount());
        verify(owners).save(owner);
    }
}
