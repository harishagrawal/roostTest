package org.springframework.samples.petclinic.owner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.ui.ModelMap;

public class PetController_initUpdateForm_24038d0750_Test {
    private static final int PET_ID = 1;
    private static final String VIEWS_PETS_CREATE_OR_UPDATE_FORM = "pets/createOrUpdatePetForm";
    private Owner owner;
    private Pet pet;
    private ModelMap model;

    @BeforeEach
    public void setup() {
        owner = mock(Owner.class);
        pet = mock(Pet.class);
        model = new ModelMap();
        when(owner.getPet(PET_ID)).thenReturn(pet);
    }

    @Test
    public void testInitUpdateForm_success() {
        String view = initUpdateForm(owner, PET_ID, model);
        assertEquals(VIEWS_PETS_CREATE_OR_UPDATE_FORM, view);
        assertEquals(pet, model.get("pet"));
    }

    @Test
    public void testInitUpdateForm_petNotFound() {
        when(owner.getPet(PET_ID)).thenReturn(null);
        String view = initUpdateForm(owner, PET_ID, model);
        assertEquals(VIEWS_PETS_CREATE_OR_UPDATE_FORM, view);
        assertEquals(null, model.get("pet"));
    }

    public String initUpdateForm(Owner owner, int petId, ModelMap model) {
        Pet pet = owner.getPet(petId);
        model.put("pet", pet);
        return VIEWS_PETS_CREATE_OR_UPDATE_FORM;
    }
}
