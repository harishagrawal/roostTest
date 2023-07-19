package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.samples.petclinic.model.Pet;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class Owner_getPets_625ddd4069_Test {

    private Owner owner;

    private List<Pet> pets;

    @BeforeEach
    public void setup() {
        owner = new Owner();
        pets = new ArrayList<>();
        Pet pet1 = new Pet();
        pet1.setName("Dog");
        pets.add(pet1);
        Pet pet2 = new Pet();
        pet2.setName("Cat");
        pets.add(pet2);
        owner.setPetsInternal(pets);
    }

    @Test
    public void testGetPetsSuccess() {
        List<Pet> result = owner.getPets();
        assertEquals(pets, result);
    }

    @Test
    public void testGetPetsFailure() {
        owner = new Owner();
        List<Pet> result = owner.getPets();
        assertEquals(new ArrayList<>(), result);
    }
}
