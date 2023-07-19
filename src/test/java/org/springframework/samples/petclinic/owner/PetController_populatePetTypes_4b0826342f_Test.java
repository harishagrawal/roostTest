package org.springframework.samples.petclinic.owner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class PetController_populatePetTypes_4b0826342f_Test {

    @InjectMocks
    PetController petController = new PetController();

    @Mock
    OwnerRepository owners;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testPopulatePetTypes() {
        PetType dog = new PetType();
        dog.setName("dog");
        PetType cat = new PetType();
        cat.setName("cat");

        List<PetType> petTypes = Arrays.asList(dog, cat);

        when(owners.findPetTypes()).thenReturn(petTypes);

        Collection<PetType> returnedPetTypes = petController.populatePetTypes();

        assertEquals(petTypes, returnedPetTypes, "Returned pet types should match the expected pet types");
    }

    @Test
    public void testPopulatePetTypes_Empty() {
        List<PetType> petTypes = Arrays.asList();

        when(owners.findPetTypes()).thenReturn(petTypes);

        Collection<PetType> returnedPetTypes = petController.populatePetTypes();

        assertEquals(petTypes, returnedPetTypes, "Returned pet types should be empty");
    }
}
