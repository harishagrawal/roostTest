package org.springframework.samples.petclinic.owner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.ModelMap;

public class PetController_initUpdateForm_24038d0750_Test {

    @Mock
    private Owner owner;

    @Mock
    private Pet pet;

    private ModelMap model;

    private static final String VIEWS_PETS_CREATE_OR_UPDATE_FORM = "pets/createOrUpdatePetForm";

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        model = new ModelMap();
    }

    @Test
    public void testInitUpdateForm() {
        int petId = 1;
        when(owner.getPet(petId)).thenReturn(pet);

        String view = initUpdateForm(owner, petId, model);

        assertEquals(VIEWS_PETS_CREATE_OR_UPDATE_FORM, view);
        assertEquals(pet, model.get("pet"));
    }

    @Test
    public void testInitUpdateFormWithNonExistentPet() {
        int petId = 2;
        when(owner.getPet(petId)).thenReturn(null);

        String view = initUpdateForm(owner, petId, model);

        assertEquals(VIEWS_PETS_CREATE_OR_UPDATE_FORM, view);
        assertEquals(null, model.get("pet"));
    }

    public String initUpdateForm(Owner owner, int petId, ModelMap model) {
        Pet pet = owner.getPet(petId);
        model.put("pet", pet);
        return VIEWS_PETS_CREATE_OR_UPDATE_FORM;
    }
}
