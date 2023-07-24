package org.springframework.samples.petclinic.owner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.ui.ModelMap;

public class PetController_initCreationForm_b0b57b1f82_Test {

    private Owner owner;
    private ModelMap model;
    private PetController petController;
    
    @BeforeEach
    public void setup() {
        owner = mock(Owner.class);
        model = new ModelMap();
        petController = new PetController();
    }

    @Test
    public void testInitCreationForm() {
        String viewName = petController.initCreationForm(owner, model);
        assertEquals("pets/createOrUpdatePetForm", viewName);
        verify(owner).addPet((Pet)model.get("pet"));
    }

    @Test
    public void testInitCreationFormWithNullOwner() {
        String viewName = petController.initCreationForm(null, model);
        assertEquals("pets/createOrUpdatePetForm", viewName);
        verify(owner, never()).addPet(any(Pet.class));
    }
}
