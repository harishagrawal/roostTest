package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.ModelMap;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class PetController_initCreationForm_b0b57b1f82_Test {

    @Mock
    private Owner owner;

    @Mock
    private ModelMap model;

    private PetController petController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        petController = new PetController();
    }

    @Test
    public void testInitCreationForm() {
        Pet pet = new Pet();
        when(owner.addPet(pet)).thenReturn(pet);
        String view = petController.initCreationForm(owner, model);
        verify(model).put("pet", pet);
        assertEquals("VIEWS_PETS_CREATE_OR_UPDATE_FORM", view);
    }

    @Test
    public void testInitCreationForm_NullPet() {
        when(owner.addPet(null)).thenReturn(null);
        String view = petController.initCreationForm(owner, model);
        verify(model).put("pet", null);
        assertEquals("VIEWS_PETS_CREATE_OR_UPDATE_FORM", view);
    }
}
