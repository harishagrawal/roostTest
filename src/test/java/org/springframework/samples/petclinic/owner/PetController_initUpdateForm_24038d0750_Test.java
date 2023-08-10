package org.springframework.samples.petclinic.owner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.ModelMap;

public class PetController_initUpdateForm_24038d0750_Test {

    @InjectMocks
    PetController petController;

    @Mock
    Owner owner;

    @Mock
    ModelMap model;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        petController = new PetController();
        owner = new Owner();
        model = new ModelMap();
    }

    @Test
    public void testInitUpdateFormSuccess() {
        Pet pet = new Pet();
        pet.setId(1);
        when(owner.getPet(1)).thenReturn(pet);
        String view = petController.initUpdateForm(owner, 1, model);
        assertEquals("pets/createOrUpdatePetForm", view);
    }

    @Test
    public void testInitUpdateFormPetNotFound() {
        when(owner.getPet(1)).thenReturn(null);
        String view = petController.initUpdateForm(owner, 1, model);
        assertEquals("pets/createOrUpdatePetForm", view);
    }
}
