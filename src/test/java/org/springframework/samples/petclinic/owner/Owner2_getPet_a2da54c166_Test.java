package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.model.Pet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class Owner2_getPet_a2da54c166_Test {
    private Owner2 owner2;
    private Pet pet1;
    private Pet pet2;

    @BeforeEach
    public void setup() {
        owner2 = new Owner2();
        pet1 = new Pet();
        pet1.setName("Fluffy");
        pet2 = new Pet();
        pet2.setName("Fido");
        owner2.addPet(pet1);
        owner2.addPet(pet2);
    }

    @Test
    public void testGetPet_withExistingName() {
        Pet actual = owner2.getPet("Fluffy", true);
        assertEquals(pet1, actual, "Expected to get the correct pet when the name exists");
    }

    @Test
    public void testGetPet_withNonExistingName() {
        Pet actual = owner2.getPet("NotAPet", true);
        assertNull(actual, "Expected to get null when the name does not exist");
    }

    @Test
    public void testGetPet_withExistingNameButIgnoreNew() {
        pet1.setNew(true);
        Pet actual = owner2.getPet("Fluffy", true);
        assertNull(actual, "Expected to get null when the pet is new and we're ignoring new pets");
    }

    @Test
    public void testGetPet_withExistingNameAndNotIgnoreNew() {
        pet1.setNew(true);
        Pet actual = owner2.getPet("Fluffy", false);
        assertEquals(pet1, actual, "Expected to get the pet even if it is new when we're not ignoring new pets");
    }
}
