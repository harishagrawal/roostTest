package org.springframework.samples.petclinic.owner;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.model.Pet;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Owner2_getPets_625ddd4069_Test {

    private Owner owner;

    @BeforeEach
    public void setup() {
        this.owner = new Owner();
    }

    @Test
    public void testGetPets_whenNoPetsExist() {
        List<Pet> pets = this.owner.getPets();
        assertEquals(0, pets.size(), "Pets list should be empty when no pets exist");
    }

    @Test
    public void testGetPets_whenPetsExist() {
        Pet pet1 = new Pet();
        pet1.setName("Fido");
        Pet pet2 = new Pet();
        pet2.setName("Rex");

        this.owner.addPet(pet1);
        this.owner.addPet(pet2);

        List<Pet> pets = this.owner.getPets();
        assertEquals(2, pets.size(), "Pets list should contain 2 pets when 2 pets exist");
        assertEquals("Fido", pets.get(0).getName(), "First pet's name should be Fido");
        assertEquals("Rex", pets.get(1).getName(), "Second pet's name should be Rex");
    }
}
