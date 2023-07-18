package org.springframework.samples.petclinic.owner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.ui.ModelMap;

public class PetController_initCreationForm_b0b57b1f82_Test {

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
    public void testInitCreationForm_Success() {
        String view = petController.initCreationForm(owner, model);
        assertThat(view).isEqualTo("pets/createOrUpdatePetForm");
        assertThat(model.containsAttribute("pet")).isTrue();
        assertThat(owner.getPets()).contains((Pet) model.get("pet"));
    }

    @Test
    public void testInitCreationForm_Failure() {
        Pet pet = new Pet();
        when(owner.addPet(pet)).thenThrow(new RuntimeException());
        try {
            petController.initCreationForm(owner, model);
        } catch (Exception e) {
            assertThat(e).isInstanceOf(RuntimeException.class);
        }
    }
}
