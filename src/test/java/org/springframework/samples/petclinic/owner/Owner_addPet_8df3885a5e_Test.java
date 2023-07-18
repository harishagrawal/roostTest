package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.samples.petclinic.model.Pet;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class Owner_addPet_8df3885a5e_Test {

    private Owner owner;
    private Pet pet1, pet2;

    @BeforeEach
    void setup() {
        owner = new Owner();
        pet1 = Mockito.mock(Pet.class);
        pet2 = Mockito.mock(Pet.class);
    }

    @Test
    void testAddPet_NewPet() {
        Mockito.when(pet1.isNew()).thenReturn(true);
        owner.addPet(pet1);
        assertTrue(owner.getPets().contains(pet1));
    }

    @Test
    void testAddPet_ExistingPet() {
        Set<Pet> pets = new HashSet<>();
        pets.add(pet2);
        owner.setPets(pets);

        Mockito.when(pet2.isNew()).thenReturn(false);
        owner.addPet(pet2);
        assertTrue(owner.getPets().contains(pet2));
        assertEquals(1, owner.getPets().size());
    }
}
