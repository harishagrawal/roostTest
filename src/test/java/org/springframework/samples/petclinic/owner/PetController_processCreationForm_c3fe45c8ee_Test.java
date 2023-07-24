package org.springframework.samples.petclinic.owner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.ui.ModelMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class PetController_processCreationForm_c3fe45c8ee_Test {
    
    @Mock
    private Owner owner;

    @Mock
    private Owners owners;

    private Pet pet;
    private ModelMap model;
    private BindingResult result;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        pet = new Pet();
        model = new ModelMap();
        result = new BeanPropertyBindingResult(pet, "pet");
    }

    @Test
    public void testProcessCreationForm_duplicateName() {
        pet.setName("Fido");
        when(owner.getPet("Fido", true)).thenReturn(new Pet());
        PetController controller = new PetController();
        String view = controller.processCreationForm(owner, pet, result, model);
        assertEquals("pets/createOrUpdateForm", view);
        assertEquals("duplicate", result.getFieldError("name").getCode());
    }

    @Test
    public void testProcessCreationForm_futureBirthDate() {
        pet.setBirthDate(LocalDate.now().plusDays(1));
        PetController controller = new PetController();
        String view = controller.processCreationForm(owner, pet, result, model);
        assertEquals("pets/createOrUpdateForm", view);
        assertEquals("typeMismatch.birthDate", result.getFieldError("birthDate").getCode());
    }

    @Test
    public void testProcessCreationForm_success() {
        pet.setName("Fido");
        pet.setBirthDate(LocalDate.now().minusYears(1));
        when(owner.getPet("Fido", true)).thenReturn(null);
        when(owners.save(any(Owner.class))).thenReturn(owner);
        PetController controller = new PetController();
        String view = controller.processCreationForm(owner, pet, result, model);
        assertEquals("redirect:/owners/{ownerId}", view);
    }
}
