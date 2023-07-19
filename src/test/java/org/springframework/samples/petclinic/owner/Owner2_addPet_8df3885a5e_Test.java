package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.samples.petclinic.model.Pet;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class Owner2_addPet_8df3885a5e_Test {

    @Mock
    Pet pet;

    @InjectMocks
    Owner owner;

    @BeforeEach
    void setUp() {
        owner = new Owner();
    }

    @Test
    void testAddPet_NewPet() {
        when(pet.isNew()).thenReturn(true);
        owner.addPet(pet);

        Set<Pet> pets = owner.getPets();
        assertEquals(1, pets.size());
        assertEquals(true, pets.contains(pet));
    }

    @Test
    void testAddPet_ExistingPet() {
        when(pet.isNew()).thenReturn(false);
        owner.addPet(pet);

        Set<Pet> pets = owner.getPets();
        assertEquals(0, pets.size());
        assertEquals(false, pets.contains(pet));
    }
}
