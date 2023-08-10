package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.MapBindingResult;
import org.springframework.validation.ObjectError;

import java.time.LocalDate;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PetController_processCreationForm_c3fe45c8ee_Test {

    private Owner owner;
    private Pet pet;
    private BindingResult result;
    private ModelMap model;

    @BeforeEach
    public void setup() {
        owner = new Owner();
        pet = new Pet();
        result = new MapBindingResult(new HashMap<>(), "");
        model = new ModelMap();
    }

    @Test
    public void testProcessCreationForm_duplicateName() {
        pet.setName("Fido");
        owner.addPet(pet);

        Pet newPet = new Pet();
        newPet.setName("Fido");

        PetController controller = new PetController();
        String view = controller.processCreationForm(owner, newPet, result, model);

        assertEquals("pets/createOrUpdateForm", view);
        assertEquals(1, result.getErrorCount());
        assertEquals("name", ((ObjectError)result.getAllErrors().get(0)).getCodes()[0]);
    }

    @Test
    public void testProcessCreationForm_futureBirthDate() {
        pet.setBirthDate(LocalDate.now().plusDays(1));

        PetController controller = new PetController();
        String view = controller.processCreationForm(owner, pet, result, model);

        assertEquals("pets/createOrUpdateForm", view);
        assertEquals(1, result.getErrorCount());
        assertEquals("birthDate", ((ObjectError)result.getAllErrors().get(0)).getCodes()[0]);
    }

    @Test
    public void testProcessCreationForm_success() {
        pet.setName("Fido");
        pet.setBirthDate(LocalDate.now().minusYears(1));

        OwnerRepository owners = mock(OwnerRepository.class);
        when(owners.save(owner)).thenReturn(owner);

        PetController controller = new PetController();
        String view = controller.processCreationForm(owner, pet, result, model);

        assertEquals("redirect:/owners/" + owner.getId(), view);
        assertEquals(0, result.getErrorCount());
    }
}
