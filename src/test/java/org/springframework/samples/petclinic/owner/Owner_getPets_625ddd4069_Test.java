package org.springframework.samples.petclinic.owner;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.springframework.samples.petclinic.model.Pet;

public class Owner_getPets_625ddd4069_Test {

    private Owner owner;

    @BeforeEach
    public void setup() {
        owner = new Owner();
        Pet pet1 = new Pet();
        pet1.setName("Fido");
        Pet pet2 = new Pet();
        pet2.setName("Whiskers");

        owner.addPet(pet1);
        owner.addPet(pet2);
    }

    @Test
    public void testGetPets() {
        List<Pet> pets = owner.getPets();
        assertEquals(2, pets.size());
        assertEquals("Fido", pets.get(0).getName());
        assertEquals("Whiskers", pets.get(1).getName());
    }

    @Test
    public void testGetPets_empty() {
        owner = new Owner();
        List<Pet> pets = owner.getPets();
        assertEquals(0, pets.size());
    }
}
