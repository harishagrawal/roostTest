package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.model.Owner;
import org.springframework.samples.petclinic.model.Pet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class Owner_getPet_7a4d72b0e8_Test {

    private Owner owner;
    private Pet pet1;
    private Pet pet2;

    @BeforeEach
    public void setup() {
        owner = new Owner();
        pet1 = new Pet();
        pet1.setId(1);
        pet1.setName("Fido");
        pet2 = new Pet();
        pet2.setId(2);
        pet2.setName("Rex");
        owner.addPet(pet1);
        owner.addPet(pet2);
    }

    @Test
    public void testGetPet() {
        Pet pet = owner.getPet("Fido", false);
        assertEquals(pet1, pet, "Expected and actual pets should match");

        pet = owner.getPet("Rex", false);
        assertEquals(pet2, pet, "Expected and actual pets should match");

        pet = owner.getPet("Non-existent", false);
        assertNull(pet, "Expected null when pet id doesn't exist");
    }

    @Test
    public void testGetPetWithNewPets() {
        Pet newPet = new Pet();
        newPet.setName("Buddy");
        owner.addPet(newPet);

        Pet pet = owner.getPet("Buddy", true);
        assertNull(pet, "Expected null when pet is new");
    }
}
