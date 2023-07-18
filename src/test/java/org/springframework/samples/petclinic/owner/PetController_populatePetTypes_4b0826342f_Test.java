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
import org.springframework.samples.petclinic.model.PetType;

public class PetController_populatePetTypes_4b0826342f_Test {

    @InjectMocks
    PetController petController = new PetController();

    @Mock
    OwnerRepository owners = new OwnerRepository();

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testPopulatePetTypes() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType cat = new PetType();
        cat.setName("Cat");
        List<PetType> petTypes = Arrays.asList(dog, cat);

        when(owners.findPetTypes()).thenReturn(petTypes);

        Collection<PetType> returnedPetTypes = petController.populatePetTypes();

        assertEquals(2, returnedPetTypes.size());
        assertEquals(petTypes, returnedPetTypes);
    }

    @Test
    public void testPopulatePetTypes_Empty() {
        when(owners.findPetTypes()).thenReturn(Arrays.asList());

        Collection<PetType> returnedPetTypes = petController.populatePetTypes();

        assertEquals(0, returnedPetTypes.size());
    }
}
