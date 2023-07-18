package org.springframework.samples.petclinic.owner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.ui.ModelMap;

public class PetController_initUpdateForm_24038d0750_Test {
    private PetController petController;
    private Owner owner;
    private ModelMap model;
    private Pet pet;

    @BeforeEach
    public void setup() {
        petController = new PetController();
        owner = mock(Owner.class);
        model = new ModelMap();
        pet = new Pet();
    }

    @Test
    public void testInitUpdateForm_petExists() {
        int petId = 1;
        when(owner.getPet(petId, true)).thenReturn(pet);

        String view = petController.initUpdateForm(owner, petId, model);

        assertEquals("pets/createOrUpdateForm", view);
        assertEquals(pet, model.get("pet"));
    }

    @Test
    public void testInitUpdateForm_petDoesNotExist() {
        int petId = 1;
        when(owner.getPet(petId, true)).thenReturn(null);

        String view = petController.initUpdateForm(owner, petId, model);

        assertEquals("pets/createOrUpdateForm", view);
        assertEquals(null, model.get("pet"));
    }
}
