package org.springframework.samples.petclinic.owner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.ui.ModelMap;

import java.util.Collections;

public class PetController_initCreationForm_b0b57b1f82_Test {

    private static final String VIEWS_PETS_CREATE_OR_UPDATE_FORM = "pets/createOrUpdatePetForm";
    private Owner owner;
    private ModelMap model;

    @BeforeEach
    public void setup() {
        owner = new Owner();
        model = new ModelMap();
    }

    @Test
    public void testInitCreationForm() {
        PetController petController = new PetController();
        String view = petController.initCreationForm(owner, model);
        assertEquals(VIEWS_PETS_CREATE_OR_UPDATE_FORM, view);
        assertEquals(owner.getPets().size(), 1);
        assertEquals(model.get("pet"), owner.getPets().get(0));
    }

    @Test
    public void testInitCreationFormWithMockOwner() {
        Owner mockOwner = mock(Owner.class);
        Pet pet = new Pet();
        when(mockOwner.getPets()).thenReturn(Collections.singletonList(pet));
        PetController petController = new PetController();
        String view = petController.initCreationForm(mockOwner, model);
        assertEquals(VIEWS_PETS_CREATE_OR_UPDATE_FORM, view);
        assertEquals(mockOwner.getPets().size(), 1);
        assertEquals(model.get("pet"), mockOwner.getPets().get(0));
    }
}
