package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.samples.petclinic.model.Pet;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class Owner_addPet_8df3885a5e_Test {

    @Mock
    private Pet pet;

    @InjectMocks
    private Owner owner;

    @BeforeEach
    public void setup() {
        owner = new Owner();
    }

    @Test
    public void testAddPet() {
        when(pet.isNew()).thenReturn(true);
        owner.addPet(pet);
        List<Pet> pets = owner.getPets();
        assertTrue(pets.contains(pet));
    }

    @Test
    public void testAddPetWhenPetIsNotNew() {
        when(pet.isNew()).thenReturn(false);
        owner.addPet(pet);
        List<Pet> pets = owner.getPets();
        assertFalse(pets.contains(pet));
    }
}
