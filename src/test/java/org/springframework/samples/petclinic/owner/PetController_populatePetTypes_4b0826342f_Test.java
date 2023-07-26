package org.springframework.samples.petclinic.owner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.owner.OwnerService;
import org.springframework.samples.petclinic.owner.PetController;
import org.springframework.samples.petclinic.owner.PetType;

public class PetController_populatePetTypes_4b0826342f_Test {

    private PetController petController;
    private OwnerService owners;

    @BeforeEach
    public void setup() {
        owners = mock(OwnerService.class);
        petController = new PetController(owners);
    }
    
    @Test
    public void testPopulatePetTypes() {
        PetType dog = new PetType();
        dog.setName("dog");
        PetType cat = new PetType();
        cat.setName("cat");
        when(owners.findPetTypes()).thenReturn(Arrays.asList(dog, cat));

        Collection<PetType> petTypes = petController.populatePetTypes();

        assertEquals(2, petTypes.size());
    }

    @Test
    public void testPopulatePetTypes_empty() {
        when(owners.findPetTypes()).thenReturn(Arrays.asList());

        Collection<PetType> petTypes = petController.populatePetTypes();

        assertEquals(0, petTypes.size());
    }
}
