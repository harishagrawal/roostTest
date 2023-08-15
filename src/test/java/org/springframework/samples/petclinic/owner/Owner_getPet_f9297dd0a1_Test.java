package org.springframework.samples.petclinic.owner;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.samples.petclinic.model.Person;
import static org.junit.jupiter.api.Assertions.*;

class Owner_getPet_f9297dd0a1_Test {

    private Owner owner;
    private Pet pet1;
    private Pet pet2;

    @BeforeEach
    void setUp() {
        owner = new Owner();
        pet1 = Mockito.mock(Pet.class);
        pet2 = Mockito.mock(Pet.class);

        List<Pet> petList = new ArrayList<>();
        petList.add(pet1);
        petList.add(pet2);

        Mockito.when(pet1.isNew()).thenReturn(false);
        Mockito.when(pet1.getId()).thenReturn(1);
        Mockito.when(pet1.getName()).thenReturn("Pet1");
        Mockito.when(pet2.isNew()).thenReturn(false);
        Mockito.when(pet2.getId()).thenReturn(2);
        Mockito.when(pet2.getName()).thenReturn("Pet2");

        owner.getPets().addAll(petList);
    }

    @Test
    void testGetPet_success() {
        Pet resultPet = owner.getPet("Pet1", false);
        assertEquals(pet1, resultPet, "Expected and actual pets do not match");
    }

    @Test
    void testGetPet_petDoesNotExist() {
        Pet resultPet = owner.getPet("Pet3", false);
        assertNull(resultPet, "Expected null as pet does not exist");
    }

    @Test
    void testGetPet_newPet() {
        Pet newPet = Mockito.mock(Pet.class);
        Mockito.when(newPet.isNew()).thenReturn(true);
        Mockito.when(newPet.getName()).thenReturn("Pet3");

        owner.addPet(newPet);

        Pet resultPet = owner.getPet("Pet3", false);
        assertNotNull(resultPet, "Expected pet as pet is new");
    }
}
