package org.springframework.samples.petclinic.owner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.ModelMap;

public class PetController_initCreationForm_b0b57b1f82_Test {

    private Owner owner;
    private ModelMap model;
    private PetController petController;

    @Mock
    private OwnerRepository owners;

    @Mock
    private PetRepository pets;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);

        owner = new Owner();
        model = new ModelMap();
        petController = new PetController();
    }

    @Test
    public void testInitCreationForm_Success() {
        String view = petController.initCreationForm(owner, model);
        assertEquals("pets/createOrUpdatePetForm", view);
        verify(model).put("pet", owner.getPets().iterator().next());
    }

    @Test
    public void testInitCreationForm_PetAlreadyExists() {
        Pet pet = new Pet();
        owner.addPet(pet);
        when(owners.findById(anyInt())).thenReturn(owner);
        String view = petController.initCreationForm(owner, model);
        assertEquals("pets/createOrUpdatePetForm", view);
        assertEquals(2, owner.getPets().size());
    }
}
