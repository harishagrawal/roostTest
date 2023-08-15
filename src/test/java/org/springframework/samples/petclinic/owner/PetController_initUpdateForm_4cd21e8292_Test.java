package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.ModelMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class PetController_initUpdateForm_4cd21e8292_Test {

    @InjectMocks
    PetController petController;

    @Mock
    Owner owner;

    @Mock
    ModelMap model;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
        petController = new PetController();
        owner = new Owner();
        model = new ModelMap();
    }

    @Test
    public void testInitUpdateForm_success() {
        Pet pet = new Pet();
        pet.setId(1);
        when(owner.getPet(1)).thenReturn(pet);
        String view = petController.initUpdateForm(owner, 1, model);
        assertEquals("pets/createOrUpdatePetForm", view);
    }

    @Test
    public void testInitUpdateForm_petNotFound() {
        when(owner.getPet(1)).thenReturn(null);
        String view = petController.initUpdateForm(owner, 1, model);
        assertEquals("pets/createOrUpdatePetForm", view);
    }
}
