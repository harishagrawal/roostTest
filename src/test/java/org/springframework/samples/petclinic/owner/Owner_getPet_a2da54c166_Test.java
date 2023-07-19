package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.model.Owner;
import org.springframework.samples.petclinic.model.Pet;

import static org.junit.jupiter.api.Assertions.*;

public class Owner_getPet_a2da54c166_Test {

    private Owner owner;
    private Pet pet1;
    private Pet pet2;

    @BeforeEach
    public void setup() {
        owner = new Owner();
        pet1 = new Pet();
        pet1.setName("Buddy");
        pet2 = new Pet();
        pet2.setName("Daisy");
        owner.addPet(pet1);
        owner.addPet(pet2);
    }

    @Test
    public void testGetPetIgnoreNew() {
        Pet pet = owner.getPet("buddy", true);
        assertNull(pet, "Pet should not be found as it is new");

        pet1.setNew(false);
        pet = owner.getPet("buddy", true);
        assertNotNull(pet, "Pet should be found as it is not new");
        assertEquals("Buddy", pet.getName(), "Pet name should be Buddy");
    }

    @Test
    public void testGetPet() {
        Pet pet = owner.getPet("daisy", false);
        assertNotNull(pet, "Pet should be found");
        assertEquals("Daisy", pet.getName(), "Pet name should be Daisy");
    }

    @Test
    public void testGetPetNotFound() {
        Pet pet = owner.getPet("unknown", false);
        assertNull(pet, "Pet should not be found");
    }
}
