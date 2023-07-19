package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.samples.petclinic.model.Pet;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

public class Owner2_getPet_7a4d72b0e8_Test {

    @Mock
    private Owner owner;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetPetSuccess() {
        Pet pet1 = new Pet();
        Pet pet2 = new Pet();

        List<Pet> petList = new ArrayList<>();
        petList.add(pet1);
        petList.add(pet2);

        when(owner.getPets()).thenReturn(petList);

        Pet actualPet = owner.getPet("pet2");
        Assertions.assertEquals(pet2, actualPet);
    }

    @Test
    public void testGetPetFailure() {
        Pet pet1 = new Pet();
        Pet pet2 = new Pet();

        List<Pet> petList = new ArrayList<>();
        petList.add(pet1);
        petList.add(pet2);

        when(owner.getPets()).thenReturn(petList);

        Pet actualPet = owner.getPet("pet3");
        Assertions.assertNull(actualPet);
    }

    @Test
    public void testGetPetWithNewPet() {
        Pet pet1 = new Pet();
        Pet pet2 = new Pet();
        pet2.setNew(true);

        List<Pet> petList = new ArrayList<>();
        petList.add(pet1);
        petList.add(pet2);

        when(owner.getPets()).thenReturn(petList);

        Pet actualPet = owner.getPet("pet2");
        Assertions.assertNull(actualPet);
    }
}
