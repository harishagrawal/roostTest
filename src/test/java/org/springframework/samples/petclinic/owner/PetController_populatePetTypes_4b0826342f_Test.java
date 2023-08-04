package org.springframework.samples.petclinic.owner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.owner.PetType;

public class PetController_populatePetTypes_4b0826342f_Test {

    private OwnerRepository owners;
    private PetController petController;

    @BeforeEach
    public void setup() {
        owners = mock(OwnerRepository.class);
        petController = new PetController(owners);
    }

    @Test
    public void testPopulatePetTypes() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType cat = new PetType();
        cat.setName("Cat");
        List<PetType> expectedPetTypes = Arrays.asList(dog, cat);

        when(owners.findPetTypes()).thenReturn(expectedPetTypes);

        Collection<PetType> actualPetTypes = petController.populatePetTypes();

        assertEquals(expectedPetTypes, actualPetTypes);
    }

    @Test
    public void testPopulatePetTypes_empty() {
        when(owners.findPetTypes()).thenReturn(Collections.emptyList());

        Collection<PetType> actualPetTypes = petController.populatePetTypes();

        assertEquals(Collections.emptyList(), actualPetTypes);
    }
}
