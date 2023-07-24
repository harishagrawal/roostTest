package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Owner_getPets_625ddd4069_Test {

    private Owner owner;
    private Pet pet1;
    private Pet pet2;

    @BeforeEach
    public void setup() {
        owner = new Owner();
        pet1 = new Pet();
        pet1.setName("Pet1");
        pet2 = new Pet();
        pet2.setName("Pet2");
        owner.addPet(pet1);
        owner.addPet(pet2);
    }

    @Test
    public void testGetPets() {
        List<Pet> pets = owner.getPets();
        assertEquals(2, pets.size());
        assertEquals("Pet1", pets.get(0).getName());
        assertEquals("Pet2", pets.get(1).getName());
    }

    @Test
    public void testGetPets_empty() {
        Owner emptyOwner = new Owner();
        List<Pet> pets = emptyOwner.getPets();
        assertEquals(0, pets.size());
    }
}
