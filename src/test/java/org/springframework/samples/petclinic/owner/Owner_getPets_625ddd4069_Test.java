package org.springframework.samples.petclinic.owner;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.samples.petclinic.model.Pet;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class Owner_getPets_625ddd4069_Test {

    @Mock
    private Owner owner;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetPetsSuccess() {
        List<Pet> petList = new ArrayList<>();
        Pet pet1 = new Pet();
        Pet pet2 = new Pet();
        petList.add(pet1);
        petList.add(pet2);

        when(owner.getPets()).thenReturn(petList);

        List<Pet> result = owner.getPets();

        assertEquals(petList, result);
    }

    @Test
    public void testGetPetsEmpty() {
        List<Pet> petList = new ArrayList<>();

        when(owner.getPets()).thenReturn(petList);

        List<Pet> result = owner.getPets();

        assertEquals(petList, result);
    }
}
