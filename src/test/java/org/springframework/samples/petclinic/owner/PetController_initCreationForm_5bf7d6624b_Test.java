package org.springframework.samples.petclinic.owner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.ModelMap;

@ExtendWith(MockitoExtension.class)
public class PetController_initCreationForm_5bf7d6624b_Test {

    private static final String VIEWS_PETS_CREATE_OR_UPDATE_FORM = "pets/createOrUpdatePetForm";

    private PetController petController;
    private Owner owner;
    private ModelMap model;

    @BeforeEach
    public void setup() {
        petController = new PetController();
        owner = mock(Owner.class);
        model = new ModelMap();
    }

    @Test
    public void testInitCreationForm() {
        String view = petController.initCreationForm(owner, model);

        verify(owner).addPet(any(Pet.class));
        assertEquals(VIEWS_PETS_CREATE_OR_UPDATE_FORM, view);
        assertTrue(model.containsAttribute("pet"));
    }

    @Test
    public void testInitCreationFormWithNullOwner() {
        assertThrows(NullPointerException.class, () -> {
            petController.initCreationForm(null, model);
        });
    }

    @Test
    public void testInitCreationFormWithNullModel() {
        assertThrows(NullPointerException.class, () -> {
            petController.initCreationForm(owner, null);
        });
    }
}
