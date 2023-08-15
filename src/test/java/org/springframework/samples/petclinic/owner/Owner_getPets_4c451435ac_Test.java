package org.springframework.samples.petclinic.owner;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.samples.petclinic.model.Pet;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Owner_getPets_4c451435ac_Test {

    private Owner owner;
    private List<Pet> pets;

    @BeforeEach
    public void setup() {
        owner = new Owner();
        pets = new ArrayList<>();
        Pet pet1 = Mockito.mock(Pet.class);
        Pet pet2 = Mockito.mock(Pet.class);
        pets.add(pet1);
        pets.add(pet2);
        owner.setPets(pets);
    }

    @Test
    public void testGetPets() {
        List<Pet> resultPets = owner.getPets();
        assertEquals(pets, resultPets, "Expected and actual pets should be same");
    }

    @Test
    public void testGetPetsWhenNoPets() {
        owner.setPets(new ArrayList<>());
        List<Pet> resultPets = owner.getPets();
        assertEquals(new ArrayList<>(), resultPets, "Expected and actual pets should be same when no pets");
    }
}
