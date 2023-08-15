package org.springframework.samples.petclinic.owner;

import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class PetController_processUpdateForm_8b32776c46_Test {

    @Test
    public void testProcessUpdateForm_petNameAlreadyExists() {
        Pet pet = new Pet();
        pet.setName("Buddy");
        pet.setId(1);

        Owner owner = new Owner();
        Pet existingPet = new Pet();
        existingPet.setName("buddy");
        existingPet.setId(2);
        owner.addPet(existingPet);

        BindingResult result = Mockito.mock(BindingResult.class);
        ModelMap model = new ModelMap();
        
        PetController controller = new PetController();
        String view = controller.processUpdateForm(pet, result, owner.getId(), model);

        when(result.hasErrors()).thenReturn(true);
        assertEquals("pets/createOrUpdateForm", view);
    }

    @Test
    public void testProcessUpdateForm_birthDateAfterCurrentDate() {
        Pet pet = new Pet();
        pet.setName("Buddy");
        pet.setBirthDate(LocalDate.now().plusDays(1));

        Owner owner = new Owner();

        BindingResult result = Mockito.mock(BindingResult.class);
        ModelMap model = new ModelMap();
        
        PetController controller = new PetController();
        String view = controller.processUpdateForm(pet, result, owner.getId(), model);

        when(result.hasErrors()).thenReturn(true);
        assertEquals("pets/createOrUpdateForm", view);
    }

    @Test
    public void testProcessUpdateForm_success() {
        Pet pet = new Pet();
        pet.setName("Buddy");
        pet.setBirthDate(LocalDate.now().minusYears(1));

        Owner owner = new Owner();

        BindingResult result = Mockito.mock(BindingResult.class);
        ModelMap model = new ModelMap();
        
        PetController controller = new PetController();
        String view = controller.processUpdateForm(pet, result, owner.getId(), model);

        when(result.hasErrors()).thenReturn(false);
        assertEquals("redirect:/owners/{ownerId}", view);
    }
}
