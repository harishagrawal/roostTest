package org.springframework.samples.petclinic.owner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.ModelMap;

@RunWith(SpringRunner.class)
public class PetController_initUpdateForm_24038d0750_Test {

    @Autowired
    private PetController petController;

    private Owner owner;
    private ModelMap model;
    private static final String VIEWS_PETS_CREATE_OR_UPDATE_FORM = "pets/createOrUpdatePetForm";

    @Before
    public void setup() {
        owner = mock(Owner.class);
        model = new ModelMap();
    }

    @Test
    public void testInitUpdateFormSuccess() {
        Pet pet = new Pet();
        pet.setId(1);
        when(owner.getPet(1)).thenReturn(pet);

        String view = petController.initUpdateForm(owner, 1, model);

        assertNotNull(model.get("pet"));
        assertEquals(VIEWS_PETS_CREATE_OR_UPDATE_FORM, view);
    }

    @Test
    public void testInitUpdateFormFailure() {
        when(owner.getPet(1)).thenReturn(null);

        String view = petController.initUpdateForm(owner, 1, model);

        assertEquals(VIEWS_PETS_CREATE_OR_UPDATE_FORM, view);
    }
}
