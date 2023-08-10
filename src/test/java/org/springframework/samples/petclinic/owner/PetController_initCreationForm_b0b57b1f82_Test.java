package org.springframework.samples.petclinic.owner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.ui.ModelMap;

public class PetController_initCreationForm_b0b57b1f82_Test {

    private Owner owner;
    private ModelMap model;
    private Pet pet;

    @BeforeEach
    public void setup() {
        owner = mock(Owner.class);
        model = mock(ModelMap.class);
        pet = new Pet();
    }

    @Test
    public void testInitCreationForm_Success() {
        when(owner.addPet(pet)).thenReturn(pet);
        String view = initCreationForm(owner, model);
        verify(model).addAttribute("pet", pet);
        assertEquals("VIEWS_PETS_CREATE_OR_UPDATE_FORM", view);
    }

    @Test
    public void testInitCreationForm_Failure() {
        when(owner.addPet(pet)).thenReturn(null);
        String view = initCreationForm(owner, model);
        verify(model).addAttribute("pet", pet);
        assertEquals("VIEWS_PETS_CREATE_OR_UPDATE_FORM", view);
    }

    public String initCreationForm(Owner owner, ModelMap model) {
        Pet pet = new Pet();
        owner.addPet(pet);
        model.addAttribute("pet", pet);
        return "VIEWS_PETS_CREATE_OR_UPDATE_FORM";
    }
}
