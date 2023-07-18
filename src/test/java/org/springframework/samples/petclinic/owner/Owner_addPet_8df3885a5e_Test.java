package org.springframework.samples.petclinic.owner;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.model.Pet;
import static org.junit.jupiter.api.Assertions.*;

public class Owner_addPet_8df3885a5e_Test {

    private Owner owner;
    private Pet pet1;
    private Pet pet2;

    @BeforeEach
    public void setup() {
        owner = new Owner();
        pet1 = new Pet();
        pet2 = new Pet();
    }

    @Test
    public void testAddPet_NewPet() {
        owner.addPet(pet1);
        Set<Pet> pets = new HashSet<>();
        pets.add(pet1);
        assertEquals(pets, owner.getPets());
    }

    @Test
    public void testAddPet_ExistingPet() {
        owner.addPet(pet1);
        owner.addPet(pet1);
        Set<Pet> pets = new HashSet<>();
        pets.add(pet1);
        assertEquals(pets, owner.getPets());
    }

    @Test
    public void testAddPet_MultipleNewPets() {
        owner.addPet(pet1);
        owner.addPet(pet2);
        Set<Pet> pets = new HashSet<>();
        pets.add(pet1);
        pets.add(pet2);
        assertEquals(pets, owner.getPets());
    }
}
