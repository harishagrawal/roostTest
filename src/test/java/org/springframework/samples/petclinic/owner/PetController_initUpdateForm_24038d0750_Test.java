package org.springframework.samples.petclinic.owner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.ui.ModelMap;

public class PetController_initUpdateForm_24038d0750_Test {

    private Owner owner;
    private Pet pet;
    private ModelMap model;

    @BeforeEach
    public void setUp() {
        owner = mock(Owner.class);
        pet = mock(Pet.class);
        model = new ModelMap();
    }

    @Test
    public void testInitUpdateForm_success() {
        when(owner.getPet(1)).thenReturn(pet);
        String view = initUpdateForm(owner, 1, model);
        assertEquals("pets/createOrUpdatePetForm", view);
        assertEquals(pet, model.get("pet"));
    }

    @Test
    public void testInitUpdateForm_petNotFound() {
        when(owner.getPet(1)).thenReturn(null);
        String view = initUpdateForm(owner, 1, model);
        assertEquals("pets/createOrUpdatePetForm", view);
        assertEquals(null, model.get("pet"));
    }

    public String initUpdateForm(Owner owner, int petId, ModelMap model) {
        Pet pet = owner.getPet(petId);
        model.put("pet", pet);
        return "pets/createOrUpdatePetForm";
    }
}
