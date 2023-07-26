package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.samples.petclinic.model.Pet;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class Owner_getPets_625ddd4069_Test {

    private Owner owner;

    @BeforeEach
    public void setup() {
        this.owner = new Owner();
    }

    @Test
    public void testGetPets_whenNoPets() {
        List<Pet> pets = this.owner.getPets();
        assertTrue(pets.isEmpty());
    }

    @Test
    public void testGetPets_whenPetsExist() {
        Pet pet1 = new Pet();
        pet1.setName("Rex");
        Pet pet2 = new Pet();
        pet2.setName("Max");

        List<Pet> petList = new ArrayList<>();
        petList.add(pet1);
        petList.add(pet2);

        this.owner.setPets(petList);

        List<Pet> pets = this.owner.getPets();
        assertEquals(2, pets.size());
        assertEquals("Rex", pets.get(0).getName());
        assertEquals("Max", pets.get(1).getName());
    }
}
